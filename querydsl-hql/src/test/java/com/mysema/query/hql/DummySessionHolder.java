/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.hql;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.mysema.query.hql.hibernate.SessionHolder;

public class DummySessionHolder implements SessionHolder{

    @Override
    public Query createQuery(String queryString) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLQuery createSQLQuery(String queryString) {
        throw new UnsupportedOperationException();
    }

}
