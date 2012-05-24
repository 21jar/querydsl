/*
 * Copyright 2011, Mysema Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mysema.query;

import java.util.Calendar;

import com.mysema.query.types.Constant;
import com.mysema.query.types.ConstantImpl;
import com.mysema.query.types.Visitor;
import com.mysema.query.types.expr.DateExpression;
import com.mysema.query.types.expr.NumberExpression;

/**
 * @author tiwe
 *
 */
final class DateConstant<D extends java.util.Date> extends DateExpression<D> implements Constant<D>{

    private static final long serialVersionUID = -5745611667058255826L;

    public static <D extends java.util.Date> DateExpression<D> create(D date){
        return new DateConstant<D>(date);
    }

    private final D date;

    private final Calendar calendar;

    @SuppressWarnings("unchecked")
    public DateConstant(D date) {
        super(new ConstantImpl<D>(date));
        this.date = (D) date.clone();
        this.calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    @Override
    public final <R,C> R accept(Visitor<R,C> v, C context) {
        return v.visit(this, context);
    }
    
    @Override
    public NumberExpression<Integer> dayOfMonth(){
        return NumberConstant.create(calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public NumberExpression<Integer> month(){
        return NumberConstant.create(calendar.get(Calendar.MONTH) + 1);
    }

    @Override
    public NumberExpression<Integer> year(){
        return NumberConstant.create(calendar.get(Calendar.YEAR));
    }

    @Override
    public NumberExpression<Integer> yearMonth(){
        return NumberConstant.create(calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH) + 1);
    }

    @Override
    public NumberExpression<Integer> dayOfWeek() {
        return NumberConstant.create(calendar.get(Calendar.DAY_OF_WEEK));
    }

    @Override
    public NumberExpression<Integer> dayOfYear() {
        return NumberConstant.create(calendar.get(Calendar.DAY_OF_YEAR));
    }

    @Override
    public NumberExpression<Integer> week() {
        return NumberConstant.create(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    @Override
    public D getConstant() {
        return date;
    }

}
