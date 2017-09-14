package ar.edu.um.umbooks.gson2;

import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import com.google.gson.*;

import ar.edu.um.umbooks.clasesApi.JSON;
import ar.edu.um.umbooks.operacion.ConsultasLibros;

public class App 
{
    public static void main( String[] args ) throws MalformedURLException, JsonSyntaxException, JsonIOException  {
    	try {
    		
    		
    		JSON resultado = new JSON();
    		resultado = ConsultasLibros.getConsultaVolumen("j k rowling");
    		for (int i = 0; i < resultado.getItems().size(); i++) {
    			System.out.println(resultado.getItems().get(i).getVolumeInfo().getTitle());
			}
    		 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  	
       
    }
}
