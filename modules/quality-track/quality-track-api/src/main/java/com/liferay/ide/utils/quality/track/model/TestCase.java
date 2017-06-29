/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.ide.utils.quality.track.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TestCase service. Represents a row in the &quot;qualitytrack_TestCase&quot; database table, with each column mapped to a property of this class.
 *
 * @author Terry Jia
 * @see TestCaseModel
 * @see com.liferay.ide.utils.quality.track.model.impl.TestCaseImpl
 * @see com.liferay.ide.utils.quality.track.model.impl.TestCaseModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.ide.utils.quality.track.model.impl.TestCaseImpl")
@ProviderType
public interface TestCase extends TestCaseModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.ide.utils.quality.track.model.impl.TestCaseImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TestCase, Long> TEST_CASE_ID_ACCESSOR = new Accessor<TestCase, Long>() {
			@Override
			public Long get(TestCase testCase) {
				return testCase.getTestCaseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TestCase> getTypeClass() {
				return TestCase.class;
			}
		};
}