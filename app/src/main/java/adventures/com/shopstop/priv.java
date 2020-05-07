package adventures.com.shopstop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class priv extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_priv, container, false);
        webView=(WebView)view.findViewById(R.id.webview);
        webView.loadUrl("https://www.kookyinfomedia.com");
        return view;
    }
    WebView webView;

}