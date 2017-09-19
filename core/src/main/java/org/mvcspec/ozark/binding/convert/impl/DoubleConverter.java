/*
 * Copyright © 2017 Ivar Grimstad (ivar.grimstad@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mvcspec.ozark.binding.convert.impl;

import org.mvcspec.ozark.binding.convert.ConverterResult;

import java.text.ParseException;
import java.util.Locale;

/**
 * Converter for double primitive or wrapper types.
 *
 * @author Christian Kaltepoth
 */
public class DoubleConverter extends NumberConverter<Double> {

    @Override
    public boolean supports(Class<Double> rawType) {
        return Double.class.equals(rawType) || Double.TYPE.equals(rawType);
    }

    @Override
    public ConverterResult<Double> convert(String value, Class<Double> rawType, Locale locale) {

        try {

            return ConverterResult.success(parseNumber(value, locale).doubleValue());

        } catch (ParseException e) {
            Double defaultValue = Double.TYPE.equals(rawType) ? 0.0 : null;
            return ConverterResult.failed(defaultValue, e.getMessage());
        }

    }
}
