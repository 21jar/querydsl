/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query._derby;

import org.junit.runner.RunWith;

import com.mysema.query.AbstractJPATest;
import com.mysema.query.EclipseLinkTemplates;
import com.mysema.query.Target;
import com.mysema.query.hql.HQLTemplates;
import com.mysema.testutil.JPAConfig;
import com.mysema.testutil.JPATestRunner;

/**
 * @author tiwe
 *
 */
@RunWith(JPATestRunner.class)
@JPAConfig("derby-eclipselink")
public abstract class DerbyJPAEclipseLinkTest extends AbstractJPATest{
    
    protected HQLTemplates getTemplates(){
	return EclipseLinkTemplates.DEFAULT;
    }
    
    @Override
    protected Target getTarget() {
        return Target.DERBY;
    }
    
}
