/*******************************************************************************
 * Copyright 2014 Trevor Robinson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.scurrilous.circe;

import static com.scurrilous.circe.params.CrcParameters.CRC32C;
import java.nio.ByteBuffer;
import org.junit.Test;
import com.scurrilous.circe.crc.Sse42Crc32CProvider;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("javadoc")
public class Crc32cSSE42Test {

	@Test
	public void testSSE42Crc32C() {
		IncrementalIntHash NATIVE_CRC32C_HASH = new Sse42Crc32CProvider().getIncrementalInt(CRC32C);
		final ByteBuffer directBuf = ByteBuffer.allocateDirect(1024);
		int checksum = NATIVE_CRC32C_HASH.calculate(directBuf);
		assertEquals(0xeeaede7c, checksum);
	}

}
