/*
 * Copyright (c) 2002-2017, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.parisvideo.service;

import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.client.Call;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.axis.transport.http.HTTPTransport;

public class SingleSessionHttpTransport extends HTTPTransport {

	private static Object uniqueCookie1 = null;
	private static Object uniqueCookie2 = null;

	@Override
	public void setupMessageContextImpl( MessageContext mc, Call call, AxisEngine engine ) throws AxisFault {
		super.setupMessageContextImpl( mc, call, engine );

		if ( uniqueCookie1 != null )
			mc.setProperty( HTTPConstants.HEADER_COOKIE, uniqueCookie1 );
		if ( uniqueCookie2 != null )
			mc.setProperty( HTTPConstants.HEADER_COOKIE2, uniqueCookie2 );

	}

	@Override
	public void processReturnedMessageContext( MessageContext context ) {

		super.processReturnedMessageContext( context );

		uniqueCookie1 = context.getProperty( HTTPConstants.HEADER_COOKIE );
		uniqueCookie2 = context.getProperty( HTTPConstants.HEADER_COOKIE2 );
	}
}
