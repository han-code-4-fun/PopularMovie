package popularmovies.examlple.com.popularmovies.Utils;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

import popularmovies.examlple.com.popularmovies.BuildConfig;

public final class MyURL {

    //class that returns url

    private static final String LOG_TAG = MyURL.class.getSimpleName();

    //todo, first step, put your own API key here
    private static final String MOVIEDB_API_KEY = BuildConfig.ApiKey;;

    private static final String BASE_URL_MOVIE = "https://api.themoviedb.org/3/movie/";

    private static final String BASE_URL_IMAGE = "https://image.tmdb.org/t/p/";

    private static final String IMAGE_SIZE = "w185";


    private static final String API_PARAM = "api_key";






    public static void errorLogURL(Exception e)
    {
        Log.e(LOG_TAG, "error creating URL: "+ e.getStackTrace().toString());
    }

    public static URL createURL( String sortingFilter)
    {
        Uri temp = Uri.parse(BASE_URL_MOVIE).buildUpon()
                .appendPath(sortingFilter)
                .appendQueryParameter(API_PARAM,MOVIEDB_API_KEY)
                .build();
        URL output = null;
        try
        {
            output = new URL(temp.toString());
        }catch(MalformedURLException e)
        {
           errorLogURL(e);
        }

        return output;
    }


    public static URL createImageURL(String imagePartialUrl)
    {
        URL output = null;
        try {
            output = new URL(BASE_URL_IMAGE+IMAGE_SIZE+imagePartialUrl);
        } catch (MalformedURLException e) {
            errorLogURL(e);
        }
        return output;
    }



}
