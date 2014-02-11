package com.sp1.s2demo3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sp1.s2demo3.R;

public class CountryInfoFragment extends Fragment {

	private WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_country_info, container, false);
		
		webView = (WebView)view.findViewById(R.id.webView);
				
		return view;
				
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
		Activity ac = new Activity();
		if(ac instanceof CountryDetailActivity)
		{
			String country = ((CountryDetailActivity)getActivity()).getPais();
			
			loadWebViewContent(country);
		}
		
	}
	
	public void loadWebViewContent(String country)
	{
		webView.loadUrl("http://es.m.wikipedia.org/wiki/"+ country);
		webView.setWebViewClient(new WebViewClient(){
		
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}
		});
	}
	
}
