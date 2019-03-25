package br.com.casadocodigo.loja.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private AmazonS3Client s3;

	public String write(String baseFolder, MultipartFile multipartFile) {
		try {
			s3.putObject("casadocodigo", multipartFile.getOriginalFilename(), multipartFile.getInputStream(),
					new ObjectMetadata());
			return "http://localhost:8080/s3/casadocodigo/" + multipartFile.getOriginalFilename() + "?noAuth=true";
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}

	}

//	public String write(String baseFolder, MultipartFile multipartFile) {
//		AmazonS3Client s3 = client();
//		try {
//			s3.putObject("casadocodigo", multipartFile.getOriginalFilename(), multipartFile.getInputStream(),
//					new ObjectMetadata());
//			return "https://s3.amazonaws.com/casadocodigo/" + multipartFile.getOriginalFilename();
//		} catch (AmazonClientException | IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	private AmazonS3Client client() {
//		AWSCredentials credentials = new BasicAWSCredentials();
//		AmazonS3Client newClient = new AmazonS3Client(credentials, new ClientConfiguration());
//		newClient.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
//		return newClient;
//		}
}
