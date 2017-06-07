package com.liferay.ide.utils.library.listener.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
	id = "com.liferay.ide.utils.library.listener.configuration.LibraryListenerConfiguration"
)
public interface LibraryListenerConfiguration {

	@Meta.AD(required = false)
	public boolean enableListener();

	@Meta.AD(required = false)
	public int hours();

	@Meta.AD(required = false)
	public String[] notifyEmailList();

	@Meta.AD(required = false)
	public String emailSender();

}
