package com.microservicesuniversity.studentservice.service;

import com.microservicesuniversity.studentservice.entity.Student;
import com.microservicesuniversity.studentservice.feignclients.AddressFeignClient;
import com.microservicesuniversity.studentservice.repository.StudentRepository;
import com.microservicesuniversity.studentservice.request.CreateStudentRequest;
import com.microservicesuniversity.studentservice.response.AddressResponse;
import com.microservicesuniversity.studentservice.response.StudentResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {


	StudentRepository studentRepository;

	WebClient webClient;

	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		return new StudentResponse(student);
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddresById(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

	public AddressResponse getAddresById (long addressId) {
		Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + addressId)
				.retrieve().bodyToMono(AddressResponse.class);

		return addressResponse.block();
	}
}
