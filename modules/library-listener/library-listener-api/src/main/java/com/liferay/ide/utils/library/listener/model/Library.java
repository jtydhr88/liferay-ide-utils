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

package com.liferay.ide.utils.library.listener.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Library service. Represents a row in the &quot;liblistener_Library&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LibraryModel
 * @see com.liferay.ide.utils.library.listener.model.impl.LibraryImpl
 * @see com.liferay.ide.utils.library.listener.model.impl.LibraryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.ide.utils.library.listener.model.impl.LibraryImpl")
@ProviderType
public interface Library extends LibraryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.ide.utils.library.listener.model.impl.LibraryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Library, Long> LIBRARY_ID_ACCESSOR = new Accessor<Library, Long>() {
			@Override
			public Long get(Library library) {
				return library.getLibraryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Library> getTypeClass() {
				return Library.class;
			}
		};
}