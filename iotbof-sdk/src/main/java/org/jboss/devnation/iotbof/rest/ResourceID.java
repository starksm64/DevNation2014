package org.jboss.devnation.iotbof.rest;/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Resource IDs from IPSO Application Framework Objects Aug 13 2013 draft.
 * <TABLE WIDTH=735 BORDER=1 BORDERCOLOR="#00000a" CELLPADDING=8 CELLSPACING=0>
 	<COL WIDTH=109>
 	<COL WIDTH=61>
 	<COL WIDTH=58>
 	<COL WIDTH=95>
 	<COL WIDTH=58>
 	<COL WIDTH=76>
 	<COL WIDTH=165>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Resource</B></FONT><FONT SIZE=2><B>
 			Name</B></FONT></P>
 		</TD>
 		<TD WIDTH=61 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Resource
 			ID *</B></FONT></P>
 		</TD>
 		<TD WIDTH=58 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Access
 			Type</B></FONT></P>
 		</TD>
 		<TD WIDTH=95 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Type</B></FONT></P>
 		</TD>
 		<TD WIDTH=58 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Range
 			or Enumeration</B></FONT></P>
 		</TD>
 		<TD WIDTH=76 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Units</B></FONT></P>
 		</TD>
 		<TD WIDTH=165 BGCOLOR="#c0c0c0">
 			<P ALIGN=CENTER STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Descriptions</B></FONT></P>
 		</TD>
 	</TR>
 		<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Digital Input State</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5500</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Boolean</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The current state of a
 			digital input.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Digital
 			Input</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Counter</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5501</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The cumulative value of
 			active state detected.  </FONT>
 			</P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Digital Input
 			Polarity</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5502</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Boolean</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The polarity of a
 			digital input as a Boolean (0 = Normal, 1= Reversed)</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Digital Input
 			Debounce Period</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5503</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>ms</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The debounce period in
 			ms. </FONT>
 			</P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Digital
 			Input</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Edge Selection</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5504</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The edge selection as
 			an integer (1 = Falling edge, 2 = Rising edge, 3 = Both Rising and
 			Falling edge)</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Digital
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Input</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Counter Reset</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5505</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>E</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Reset the Counter value</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Digital Output State</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5550</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Boolean</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The current state of a
 			digital output.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Digital Output
 			Polarity</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5551</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Boolean</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The polarity of a
 			digital input as a Boolean (0 = Normal, 1= Reversed)</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Analog</B></FONT></P>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Input</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Current Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5600</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>0-5</FONT></P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>V</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The current state of
 			the analogue input.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Min
 			Measured </B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5601</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Defined by âUnitsâ
 			resource.</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The minimum value
 			measured by the sensor since it is ON</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Max
 			Measured </B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5602</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Defined by âUnitsâ
 			resource.</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The maximum value
 			measured by the sensor since it is ON</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Min
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Range
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5603</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Defined by âUnitsâ
 			resource.</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The minimum value that
 			can be measured by the sensor</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Max
 			Range</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5604</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Defined by âUnitsâ
 			resource.</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The maximum value that
 			can be measured by the sensor</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Analog
 			Output</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Current Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5650</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>0-5</FONT></P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>V</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The current state of
 			the analogue output.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Sensor Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5700</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Defined by âUnitsâ
 			resource.</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>If present, the value
 			of the sensor. </FONT>
 			</P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Sensor Units</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5701</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>String</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>If present, the type of
 			sensor defined as the UCUM Unit Definition e.g. âCelâ for
 			Temperature in Celcius.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Application Type</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5750</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>String</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The Application type of
 			the device, for example âMotion Closureâ.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Sensor Type</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5751</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>String</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The type of the sensor
 			(for instance PIR type)</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Instantaneous active
 			power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5800</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The current active
 			power</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Min
 			Measured</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>active power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5801</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The minimum active
 			power measured by the sensor since it is ON</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Max
 			Measured </B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>active power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5802</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The maximum active
 			power measured by the sensor since it is ON</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Min
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Range
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>active power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5803</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The minimum active
 			power that can be measured by the sensor</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Max
 			Range</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>active power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5804</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The maximum active
 			power that can be measured by the sensor</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Cumulative active
 			power </B></FONT>
 			</P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5805</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Wh</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The cumulative active
 			power since the last cumulative energy reset or device start</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Active Power
 			Calibration</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5806</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Request an active power
 			calibration by writing the value of a calibrated load. </FONT>
 			</P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Instantaneous
 			reactive power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5810</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VAR</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The current reactive
 			power</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Min
 			Measured</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>reactive power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5811</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VAR</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The minimum reactive</FONT><FONT SIZE=2><B>
 			</B></FONT><FONT SIZE=2>power measured by the sensor since it is
 			ON</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Max
 			Measured </B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>reactive power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5812</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VAR</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The maximum reactive</FONT><FONT SIZE=2><B>
 			</B></FONT><FONT SIZE=2>power measured by the sensor since it is
 			ON</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Min
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Range
 			</B></FONT>
 			</P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>reactive power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5813</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VAR</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The minimum active
 			power that can be measured by the sensor</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in; margin-bottom: 0.01in"><FONT SIZE=2><B>Max
 			Range</B></FONT></P>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>reactive power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5814</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VAR</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The maximum reactive</FONT><FONT SIZE=2><B>
 			</B></FONT><FONT SIZE=2>power that can be measured by the sensor</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Cumulative reactive
 			power</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5815</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VARh</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The cumulative reactive
 			power since the last cumulative energy reset or device start</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Reactive Power
 			Calibration</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5816</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>VAR</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Request a reactive
 			power calibration by writing the value of a calibrated load.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Power factor</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5820</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>If applicable, the
 			power factor of the current consumption.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Current Calibration</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5821</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Read or Write the
 			current calibration coefficient</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Reset Cumulative
 			energy</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5822</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>E</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Reset both cumulative
 			active/reactive power</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>On/Off</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5850</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R, W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Boolean</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>This resource
 			represents an on/off actuator, which can be controlled, the
 			setting of which is a Boolean value (1,0) where 1 is on and 0 is
 			off.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Dimmer</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5851</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R, W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>0-100</FONT></P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>%</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>This resource
 			represents a dimmer setting, which has an Integer value between 0
 			and 100 as a percentage.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>On time</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5852</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R, W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>sec</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The time in seconds
 			that the device has been turned on. Writing a value of 0 resets
 			the counter.</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Muti-state Output</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5853</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>String</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>A string describing a
 			state for multiple level output such as Pilot Wire</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Set Point Value</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5900</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Decimal</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Defined by âUnitsâ
 			resource.</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>The setpoint value. </FONT>
 			</P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Busy to Clear delay</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5903</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>ms</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Delay from the
 			detection state to the clear state in ms</FONT></P>
 		</TD>
 	</TR>
 	<TR VALIGN=TOP>
 		<TD WIDTH=109>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2><B>Clear to Busy delay</B></FONT></P>
 		</TD>
 		<TD WIDTH=61>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>5904</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>R,W</FONT></P>
 		</TD>
 		<TD WIDTH=95>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Integer</FONT></P>
 		</TD>
 		<TD WIDTH=58>
 			<P STYLE="margin-top: 0.01in"><BR>
 			</P>
 		</TD>
 		<TD WIDTH=76>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>ms</FONT></P>
 		</TD>
 		<TD WIDTH=165>
 			<P STYLE="margin-top: 0.01in"><FONT SIZE=2>Delay from the clear
 			state to the busy state in ms</FONT></P>
 		</TD>
 	</TR>
 </TABLE>
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public enum ResourceID implements IResourceType {
   Colour(0, "R,W,E", "String", "", "Defined by 5701(Units) resource", "Colour of the object"),
   DigitalInputState(5500,"R","Boolean","","","The current state of a digital input."),
  	DigitalInputCounter(5501,"R","Integer","","","The cumulative value of active state detected."),
  	DigitalInputPolarity(5502,"R,W","Boolean","","","The polarity of a digital input as a Boolean (0 = Normal, 1= Reversed)"),
  	DigitalInputDebouncePeriod(5503,"R,W","Integer","","ms","The debounce period in ms."),
  	DigitalInputEdgeSelection(5504,"R,W","Integer","","","The edge selection as an integer (1 = Falling edge, 2 = Rising edge, 3 = Both Rising and Falling edge)"),
  	DigitalInputCounterReset(5505,"E","","","","Reset the Counter value"),
  	DigitalOutputState(5550,"R,W","Boolean","","","The current state of a digital output."),
  	DigitalOutputPolarity(5551,"R,W","Boolean","","","The polarity of a digital input as a Boolean (0 = Normal, 1= Reversed)"),
  	AnalogInputCurrentValue(5600,"R","Decimal","0-5","V","The current state of the analogue input."),
  	MinMeasuredValue(5601,"R","Decimal","","Defined by “Units” resource.","The minimum value measured by the sensor since it is ON"),
  	MaxMeasuredValue(5602,"R","Decimal","","Defined by “Units” resource.","The maximum value measured by the sensor since it is ON"),
  	MinRangeValue(5603,"R","Decimal","","Defined by “Units” resource.","The minimum value that can be measured by the sensor"),
  	MaxRangeValue(5604,"R","Decimal","","Defined by “Units” resource.","The maximum value that can be measured by the sensor"),
  	AnalogOutputCurrentValue(5650,"R,W","Decimal","0-5","V","The current state of the analogue output."),
  	SensorValue(5700,"R","Decimal","","Defined by “Units” resource.","If present, the value of the sensor."),
  	SensorUnits(5701,"R","String","","","If present, the type of sensor defined as the UCUM Unit Definition e.g. “Cel” for Temperature in Celcius."),
  	ApplicationType(5750,"R,W","String","","","The Application type of the device, for example “Motion Closure”."),
  	SensorType(5751,"R","String","","","The type of the sensor (for instance PIR type)"),
  	InstantaneousActivePower(5800,"R","Decimal","","W","The current active power"),
  	MinMeasuredActivePower(5801,"R","Decimal","","W","The minimum active power measured by the sensor since it is ON"),
  	MaxMeasuredActivePower(5802,"R","Decimal","","W","The maximum active power measured by the sensor since it is ON"),
  	MinRangeActivePower(5803,"R","Decimal","","W","The minimum active power that can be measured by the sensor"),
  	MaxRangeActivePower(5804,"R","Decimal","","W","The maximum active power that can be measured by the sensor"),
  	CumulativeActivePower(5805,"R","Integer","","Wh","The cumulative active power since the last cumulative energy reset or device start"),
  	ActivePowerCalibration(5806,"W","Decimal","","W","Request an active power calibration by writing the value of a calibrated load."),
  	InstantaneousReactivePower(5810,"R","Decimal","","VAR","The current reactive power"),
  	MinMeasuredReactivePower(5811,"R","Decimal","","VAR","The minimum reactive power measured by the sensor since it is ON"),
  	MaxMeasuredReactivePower(5812,"R","Decimal","","VAR","The maximum reactive power measured by the sensor since it is ON"),
  	MinRangeReactivePower(5813,"R","Decimal","","VAR","The minimum active power that can be measured by the sensor"),
  	MaxRangeReactivePower(5814,"R","Decimal","","VAR","The maximum reactive power that can be measured by the sensor"),
  	CumulativeReactivePower(5815,"R","Integer","","VARh","The cumulative reactive power since the last cumulative energy reset or device start"),
  	ReactivePowerCalibration(5816,"W","Decimal","","VAR","Request a reactive power calibration by writing the value of a calibrated load."),
  	PowerFactor(5820,"R","Integer","","","If applicable, the power factor of the current consumption."),
  	CurrentCalibration(5821,"R,W","Decimal","","","Read or Write the current calibration coefficient"),
  	ResetCumulativeEnergy(5822,"E","","","","Reset both cumulative active/reactive power"),
  	OnOff(5850,"R,W","Boolean","","","This resource represents an on/off actuator, which can be controlled, the setting of which is a Boolean value (1,0) where 1 is on and 0 is off."),
  	Dimmer(5851,"R,W","Integer","0-100","%","This resource represents a dimmer setting, which has an Integer value between 0 and 100 as a percentage."),
  	OnTime(5852,"R,W","Integer","","sec","The time in seconds that the device has been turned on. Writing a value of 0 resets the counter."),
  	MutiStateOutput(5853,"R,W","String","","","A string describing a state for multiple level output such as Pilot Wire"),
  	SetPointValue(5900,"R,W","Decimal","","Defined by “Units” resource.","The setpoint value."),
  	BusyToClearDelay(5903,"R,W","Integer","","ms","Delay from the detection state to the clear state in ms"),
  	ClearToBusyDelay(5904,"R,W","Integer","","ms","Delay from the clear state to the busy state in ms"),

   Unknown(-1, "", "", "", "", "A resource type that is not currently mapped, probably due to incomplete code")
   ;

   ResourceID(int id, String accessType, String type, String range, String units, String description) {
      this.id = id;
      this.accessType = accessType;
      this.type = type;
      this.range = range;
      this.units = units;
      this.description = description;
   }

   public String getName() {
      return this.name();
   }

   public int getID() {
      return id;
   }

   public String getAccessType() {
      return accessType;
   }

   public String getType() {
      return type;
   }

   public String getRange() {
      return range;
   }

   public String getUnits() {
      return units;
   }

   public String getDescription() {
      return description;
   }

   private int id;
   private String accessType;
   private String type;
   private String range;
   private String units;
   private String description;

   public static ResourceID valueOf(int id) {
  		ResourceID resID = Unknown;
  		switch(id) {
         case 0:
            resID = ResourceID.Colour;
            break;
  			case 5500:
  				resID = ResourceID.DigitalInputState;
  			break;
  			case 5501:
  				resID = ResourceID.DigitalInputCounter;
  			break;
  			case 5502:
  				resID = ResourceID.DigitalInputPolarity;
  			break;
  			case 5503:
  				resID = ResourceID.DigitalInputDebouncePeriod;
  			break;
  			case 5701:
  				resID = ResourceID.SensorUnits;
  			break;
  			case 5700:
  				resID = ResourceID.SensorValue;
  			break;
  			case 5904:
  				resID = ResourceID.ClearToBusyDelay;
  			break;
  			case 5903:
  				resID = ResourceID.BusyToClearDelay;
  			break;
  			case 5604:
  				resID = ResourceID.MaxRangeValue;
  			break;
  			case 5900:
  				resID = ResourceID.SetPointValue;
  			break;
  			case 5600:
  				resID = ResourceID.AnalogInputCurrentValue;
  			break;
  			case 5601:
  				resID = ResourceID.MinMeasuredValue;
  			break;
  			case 5602:
  				resID = ResourceID.MaxMeasuredValue;
  			break;
  			case 5603:
  				resID = ResourceID.MinRangeValue;
  			break;
  			case 5851:
  				resID = ResourceID.Dimmer;
  			break;
  			case 5850:
  				resID = ResourceID.OnOff;
  			break;
  			case 5853:
  				resID = ResourceID.MutiStateOutput;
  			break;
  			case 5852:
  				resID = ResourceID.OnTime;
  			break;
  			case 5550:
  				resID = ResourceID.DigitalOutputState;
  			break;
  			case 5650:
  				resID = ResourceID.AnalogOutputCurrentValue;
  			break;
  			case 5551:
  				resID = ResourceID.DigitalOutputPolarity;
  			break;
  			case 5806:
  				resID = ResourceID.ActivePowerCalibration;
  			break;
  			case 5804:
  				resID = ResourceID.MaxRangeActivePower;
  			break;
  			case 5805:
  				resID = ResourceID.CumulativeActivePower;
  			break;
  			case 5802:
  				resID = ResourceID.MaxMeasuredActivePower;
  			break;
  			case 5803:
  				resID = ResourceID.MinRangeActivePower;
  			break;
  			case 5800:
  				resID = ResourceID.InstantaneousActivePower;
  			break;
  			case 5801:
  				resID = ResourceID.MinMeasuredActivePower;
  			break;
  			case 5815:
  				resID = ResourceID.CumulativeReactivePower;
  			break;
  			case 5814:
  				resID = ResourceID.MaxRangeReactivePower;
  			break;
  			case 5813:
  				resID = ResourceID.MinRangeReactivePower;
  			break;
  			case 5504:
  				resID = ResourceID.DigitalInputEdgeSelection;
  			break;
  			case 5812:
  				resID = ResourceID.MaxMeasuredReactivePower;
  			break;
  			case 5505:
  				resID = ResourceID.DigitalInputCounterReset;
  			break;
  			case 5811:
  				resID = ResourceID.MinMeasuredReactivePower;
  			break;
  			case 5810:
  				resID = ResourceID.InstantaneousReactivePower;
  			break;
  			case 5822:
  				resID = ResourceID.ResetCumulativeEnergy;
  			break;
  			case 5821:
  				resID = ResourceID.CurrentCalibration;
  			break;
  			case 5820:
  				resID = ResourceID.PowerFactor;
  			break;
  			case 5750:
  				resID = ResourceID.ApplicationType;
  			break;
  			case 5751:
  				resID = ResourceID.SensorType;
  			break;
  			case 5816:
  				resID = ResourceID.ReactivePowerCalibration;
  			break;
  		}
      return resID;
  	}
}
