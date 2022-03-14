/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.oauth2.core;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Standard token types defined in the OAuth Token Type Hints Registry.
 *
 * @author Joe Grandja
 * @see <a target="_blank" href="https://tools.ietf.org/html/rfc7009#section-4.1.2">4.1.2 OAuth Token Type Hints Registry</a>
 * @since 0.0.1
 */
public final class OAuth2TokenType implements Serializable {
	private static final long serialVersionUID = Version.SERIAL_VERSION_UID;
	public static final OAuth2TokenType ACCESS_TOKEN = new OAuth2TokenType("access_token");
	public static final OAuth2TokenType REFRESH_TOKEN = new OAuth2TokenType("refresh_token");
	private final String value;

	/**
	 * Constructs an {@code OAuth2TokenType} using the provided value.
	 *
	 * @param value the value of the token type
	 */
	public OAuth2TokenType(String value) {
		Assert.hasText(value, "value cannot be empty");
		this.value = value;
	}

	/**
	 * Returns the value of the token type.
	 *
	 * @return the value of the token type
	 */
	public String getValue() {
		return this.value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		OAuth2TokenType that = (OAuth2TokenType) obj;
		return getValue().equals(that.getValue());
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
}
