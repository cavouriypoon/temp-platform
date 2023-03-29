package com.lionrockws.temp.platform.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentsController {
	
	@Autowired
	ServletContext context;    

	
	@GetMapping(value = "/form"+ "/{docName}", produces = MediaType.APPLICATION_PDF_VALUE)
    public String previewForm(@PathVariable(required = true) String docName,HttpServletResponse response) throws IOException {
		//String absolutePath = context.getRealPath("docs/form/"+docName);
		//String absolutePath ="C:\\docs\\form\\"+docName;
		String absolutePath ="/home/ec2-user/jboss-eap-7.4/standalone/deployments/docs/form/"+docName;
        File test = new File( absolutePath );
      
        response.setHeader( "Content-Type", "application/pdf" );
        response.setHeader( "Content-Length", String.valueOf( test.length() ) );
        response.setHeader( "Content-Disposition", "inline; filename=\"form.pdf\"" );
        
        try
        {
            Files.copy( test.toPath(), response.getOutputStream() );
        }
        catch( IOException e )
        {
     
            e.printStackTrace();
        }
        return "redirect:../assign.do";
    }
     
	@GetMapping(value = "/leaflet"+ "/{docName}", produces = MediaType.APPLICATION_PDF_VALUE)
    public String previewleaflet(@PathVariable(required = true) String docName,HttpServletResponse response)  {
		//String absolutePath = context.getRealPath("docs/leaflet/"+docName);
		String absolutePath ="/home/ec2-user/jboss-eap-7.4/standalone/deployments/docs/leaflet/"+docName;
        try
        {
        	File test = new File( absolutePath );
            
            response.setHeader( "Content-Type", "application/pdf" );
            response.setHeader( "Content-Length", String.valueOf( test.length() ) );
            response.setHeader( "Content-Disposition", "inline; filename=\"leaflet.pdf\"" );
            Files.copy( test.toPath(), response.getOutputStream() );
        }
        catch( IOException e )
        {
     
            e.printStackTrace();
            return "Document not Found";
        }
        return "redirect:../assign.do";
    }
	
	@GetMapping(value = "/data"+ "/{docName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String previewPDF(@PathVariable(required = true) String docName,HttpServletResponse response) throws IOException {
      
		//String absolutePath = context.getRealPath("docs/data/"+docName);
		String absolutePath ="/home/ec2-user/jboss-eap-7.4/standalone/deployments/docs/data/"+docName;
        File test = new File( absolutePath );
      
        response.setHeader( "Content-Type", "application/json" );
        response.setHeader( "Content-Length", String.valueOf( test.length() ) );
        response.setHeader( "Content-Disposition", "inline; filename=\"data.json\"" );
        
        try
        {
            Files.copy( test.toPath(), response.getOutputStream() );
        }
        catch( IOException e )
        {
     
            e.printStackTrace();
        }
        return "redirect:../assign.do";
    }
      

}
