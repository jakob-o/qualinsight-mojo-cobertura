/*
 * qualinsight-mojo-cobertura
 * Copyright (c) 2015-2017, QualInsight
 * http://www.qualinsight.com/
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, you can retrieve a copy
 * from <http://www.gnu.org/licenses/>.
 */
package com.qualinsight.mojo.cobertura.core.instrumentation;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Mojo that instruments code to be tested by unit tests in order to be able to generate coverage report file for unit tests.
 *
 * @author Michel Pawlak
 */
@Mojo(
    name = "instrument-ut", 
    defaultPhase = LifecyclePhase.PROCESS_TEST_CLASSES,
    requiresDependencyResolution = ResolutionScope.COMPILE
)
public class UTInstrumentationMojo extends AbstractInstrumentationMojo {

    /**
     * Skips unit the tests and therefore the execution of this mojo.
     */
    @Parameter(defaultValue = "${skipUnitTests}", required = false)
    private boolean skipUnitTests;
    
    @Override
    protected boolean skipExecution() {
        return super.skipExecution() || skipUnitTests;
    }
}
