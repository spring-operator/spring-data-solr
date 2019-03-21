/*
 * Copyright 2012 - 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.solr.core.query;

import java.util.Arrays;

/**
 * Implementation of {@code max(field|function,value)}
 *
 * @author Christoph Strobl
 * @since 1.1
 */
public class MaxFunction extends AbstractFunction {

	private static final String OPERATION = "max";

	private MaxFunction(Object candiate, Object maxValue) {
		super(Arrays.asList(candiate, maxValue));
	}

	/**
	 * @param fieldName
	 * @return
	 */
	public static MaxFunction max(String fieldName, Number value) {
		return new MaxFunction(new SimpleField(fieldName), value);
	}

	/**
	 * @param fieldName
	 * @param compareFieldName
	 * @return
	 */
	public static MaxFunction max(String fieldName, String compareFieldName) {
		return new MaxFunction(new SimpleField(fieldName), new SimpleField(compareFieldName));
	}

	/**
	 * @param fieldName
	 * @return
	 */
	public static MaxFunction max(String fieldName, Function function) {
		return new MaxFunction(new SimpleField(fieldName), function);
	}

	/**
	 * @return
	 */
	public static MaxFunction max(Function function, Number value) {
		return new MaxFunction(function, value);
	}

	/**
	 * @return
	 */
	public static MaxFunction max(Function function, String fieldname) {
		return new MaxFunction(function, new SimpleField(fieldname));
	}

	/**
	 * @return
	 */
	public static MaxFunction max(Function function, Function compareFunction) {
		return new MaxFunction(function, compareFunction);
	}

	/**
	 * @return
	 */
	public static MaxFunction max(Number value, Number compareValue) {
		return new MaxFunction(value, compareValue);
	}

	/**
	 * @return
	 */
	public static MaxFunction max(Number value, String fieldName) {
		return new MaxFunction(value, new SimpleField(fieldName));
	}

	/**
	 * @return
	 */
	public static MaxFunction max(Number value, Function compareFunction) {
		return new MaxFunction(value, compareFunction);
	}

	@Override
	public String getOperation() {
		return OPERATION;
	}
}
