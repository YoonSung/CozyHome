package org.nhnnext.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nhnnext.support.FileUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

@Controller
@RequestMapping
public class JavaTermProject {

	private static final Logger log = LoggerFactory
			.getLogger(JavaTermProject.class);
	
	@RequestMapping(value = "/DBProject", method = RequestMethod.POST)
	public ResponseEntity<String> exeQueryFromYoonSung(@RequestBody String query) {
		log.debug("query : {}", query);
		
		String encodeQuery = "";
		try {
			encodeQuery = URLDecoder.decode(query, "UTF-8");
			encodeQuery = encodeQuery.substring(0, encodeQuery.length()-1);
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		log.debug("decode query : {}", encodeQuery);
		
		System.out.println("data : " + query);
		Gson gson = new Gson();
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		
		
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sql;

		String jdbcUrl = "jdbc:mysql://ihlnext.vps.phps.kr/hello_next";
		String userID = "nextuser";
		String userPW = "dbgood";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Error" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Driver Loading Success");

		try {
			conn = DriverManager.getConnection(jdbcUrl, userID, userPW);
			System.out.println("Connection Success");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(encodeQuery);
			
			System.out.println("rs = "+rs.toString());
			
			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {
			    Map<String, Object> columns = new LinkedHashMap<String, Object>();

			    for (int i = 1; i <= columnCount; i++) {
			    	System.out.println("column label : "+metaData.getColumnLabel(i));
			    	System.out.println("getObject : "+ rs.getObject(i));
			        columns.put(metaData.getColumnLabel(i), rs.getObject(i));
			    }
			    rows.add(columns);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("DB Error" + e.getMessage());
		}
		log.debug(gson.toJson(rows));
		
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(rows), responseHeaders, HttpStatus.CREATED);
	}
	

	@RequestMapping(value = "/DBProject/soeun", method = RequestMethod.POST)
	public ResponseEntity<String> exeQueryFromSoeun(@RequestBody String query) {
		log.debug("query : {}", query);
		
		String encodeQuery = "";
		try {
			encodeQuery = URLDecoder.decode(query, "UTF-8");
			encodeQuery = encodeQuery.substring(0, encodeQuery.length()-1);
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		log.debug("decode query : {}", encodeQuery);
		
		Gson gson = new Gson();
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		
		
		Connection conn;
		Statement stmt;
		ResultSet rs;

		String jdbcUrl = "jdbc:mysql://ihlnext.vps.phps.kr/bookie_version2";
		String userID = "nextuser";
		String userPW = "dbgood";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Error" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Driver Loading Success");

		try {
			conn = DriverManager.getConnection(jdbcUrl, userID, userPW);
			System.out.println("Connection Success");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(encodeQuery);
			
			log.debug("rs = {} ", rs.toString());
			log.debug("rs.getRow() : {}", rs.getRow());
			
			//if ( rs.getRow() != 0 ) {
				java.sql.ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();

				while (rs.next()) {
				    Map<String, Object> columns = new LinkedHashMap<String, Object>();

				    for ( int i = 1; i <= columnCount; i++ ) {
				    	System.out.println("column label : "+metaData.getColumnLabel(i));
				    	System.out.println("getObject : "+ rs.getObject(i));
				        columns.put(metaData.getColumnLabel(i), rs.getObject(i));
				    }
				    rows.add(columns);
				}
			//}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("DB Error" + e.getMessage());
		}
		log.debug(gson.toJson(rows));
		
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(rows), responseHeaders, HttpStatus.CREATED);
	}
	
	//@RequestMapping(value="/DBProject/saveImage/{id}", method=RequestMethod.GET)
	//public void saveImage(@PathVariable int id, MultipartFile file) {
	@RequestMapping(value="/DBProject/saveImage", method=RequestMethod.POST)
	public @ResponseBody boolean saveImage(MultipartRequest multipartRequest) {
		log.debug("test : test in part ");
		//log.debug("id : "+id);
		//file.get
		
		Iterator<String> files = multipartRequest.getFileNames();

		 while (files.hasNext()) {
			   String key = (String)files.next();
			   log.debug("key : "+key);
			   MultipartFile file = multipartRequest.getFile(key);
			   log.debug("file : "+file);
			   String uploadFileName = FileUploader.upload(file);
			   log.debug("uploadFileName : "+uploadFileName );
		 }
			
		return true;
	}
}
