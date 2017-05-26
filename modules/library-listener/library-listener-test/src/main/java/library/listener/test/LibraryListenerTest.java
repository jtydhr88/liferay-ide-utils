package library.listener.test;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.service.LibraryLocalServiceUtil;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalServiceUtil;

/**
 * @author Andy Wu
 */
public class LibraryListenerTest implements BundleActivator
{

    @Override
    public void start( BundleContext context ) throws Exception
    {
        Repository existingRepo = RepositoryLocalServiceUtil.fetchRepository( 0 );

        if( existingRepo == null )
        {
            Repository repository = RepositoryLocalServiceUtil.createRepository( 0 );
            repository.setRepositoryName( "liferay repo" );
            repository.setRepositoryRootUrl(
                "https://repository.liferay.com/nexus/content/repositories/liferay-public-releases" );

            RepositoryLocalServiceUtil.updateRepository( repository );

            Library library = LibraryLocalServiceUtil.createLibrary( 0 );
            library.setRepositoryId( repository.getPrimaryKey() );
            library.setLibraryGroupId( "com.liferay.portal" );
            library.setLibraryArtifactId( "com.liferay.portal.plugins.sdk" );
            LibraryLocalServiceUtil.updateLibrary( library );
        }
    }

    @Override
    public void stop( BundleContext context ) throws Exception
    {
    }
}
