
package com.liferay.ide.utils.library.listener.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osgi.framework.Version;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Andy Wu
 */
public class LibraryUtil
{

    public static String getLatestVersion( String repoURL, String libraryGroupId, String libraryArtifactId )
        throws Exception
    {
        StringBuilder sb = new StringBuilder();

        sb.append( repoURL );

        if( !repoURL.endsWith( "/" ) )
        {
            sb.append( "/" );
        }

        String[] groupPaths = libraryGroupId.split( "\\." );

        for( String groupPath : groupPaths )
        {
            sb.append( groupPath );
            sb.append( "/" );
        }

        sb.append( libraryArtifactId );
        sb.append( "/" );

        sb.append( "maven-metadata.xml" );

        InputStream inputStream = getXmlInputStream( sb.toString() );

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document document = builder.parse( inputStream );

        NodeList nodeList = document.getElementsByTagName( "version" );

        if( nodeList == null || nodeList.getLength() < 1 )
        {
            return null;
        }

        Version highestVersion = new Version( "0" );

        for( int i = 0; i < nodeList.getLength(); i++ )
        {
            Node node = nodeList.item( i );

            Version nodeVersion = new Version( node.getTextContent() );

            if( nodeVersion.compareTo( highestVersion ) > 0 )
            {
                highestVersion = nodeVersion;
            }
        }

        return highestVersion.toString();
    }

    public static InputStream getXmlInputStream( final String path )
    {
        try
        {
            final URL url = new URL( path );

            if( url != null )
            {
                final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setDoInput( true );
                connection.setConnectTimeout( 3000 );
                connection.setRequestMethod( "GET" );

                int requesetCode = connection.getResponseCode();

                if( requesetCode == 200 )
                {
                    return connection.getInputStream();
                }
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        return null;
    }

}
