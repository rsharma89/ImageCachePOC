package com.example.rakesh.myapplication.service;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.rakesh.myapplication.CallBackListener;
import com.example.rakesh.myapplication.helper.Util;
import com.example.rakesh.myapplication.model.Category;
import com.example.rakesh.myapplication.model.Country;
import com.example.rakesh.myapplication.model.ListPojo;
import com.example.rakesh.myapplication.model.ProdutDetail;
import com.example.rakesh.myapplication.network.VolleyNetworkRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by rakesh on 28/01/18.
 */

public class BabyPinkServiceClass {

    public void getCountryList(CallBackListener listener){
        ListPojo country = new Gson().fromJson(Util.loadJSONFromAsset(Util.getContext()), ListPojo.class);
        if(country!=null){
            listener.onSuccess(country.getCountry());
        }else{
            listener.onFailure();
        }
    }

    public void getCategoryList(final CallBackListener listener){
        RequestQueue queue = Volley.newRequestQueue(Util.getContext());
        String url ="http://static-data.surge.sh/categories.json";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Category country = new Gson().fromJson(response.toString(), Category.class);
                        listener.onSuccess(country.getContents());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        queue.add(jsObjRequest);
    }

    public void getCategoryData(final CallBackListener listener, String categoryId){
        RequestQueue queue = Volley.newRequestQueue(Util.getContext());
        String url = null;
        if(categoryId!=null&&categoryId.length()>0){
            url = "http://static-data.surge.sh/products/products.+categoryId.json";
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        ProdutDetail produtDetail = new Gson().fromJson(response.toString(), ProdutDetail.class);
                        listener.onSuccess(produtDetail);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        queue.add(jsObjRequest);
    }


}
