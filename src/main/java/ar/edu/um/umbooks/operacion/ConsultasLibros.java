package ar.edu.um.umbooks.operacion;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import ar.edu.um.umbooks.clasesApi.JSON;

public class ConsultasLibros {
	private static final String api = "https://www.googleapis.com/books/v1/volumes";
	private static final String apiKey = "AIzaSyDdzC-iL3m4i4d3r5xesk957JBtXX4l0Xo";

	public static JSON getConsultaVolumen(String cadena) throws JsonSyntaxException, JsonIOException, IOException {

		cadena = URLEncoder.encode(cadena, "UTF-8");
		
		String url = api + "?q=" + cadena + "&key=" + apiKey;

		String json = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting(); // Impresion en formato JSON
		Gson gson = builder.create();
		JSON resultado = gson.fromJson(json, JSON.class);
		return resultado;

	}

//	private static String parsearCadena(String cadena) {
//		String delims = "[ ]+";
//		String[] token = cadena.split(delims);
//		cadena = token[0];
//		for (int i = 1; i < token.length; i++) {
//			cadena += "+" + token[i];
//		}
//		return cadena;
//	}

}
