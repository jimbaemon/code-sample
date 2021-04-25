package rest.practice.controller;

import java.net.URI;
import java.util.NoSuchElementException;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import rest.practice.controller.dto.CustomerDTO;
import rest.practice.domain.Customer;
import rest.practice.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customers")
public class CustomerController {

	private final CustomerService customerService;
	private final ObjectMapper objectMapper;

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable Long id){
		Customer customer = customerService.findCustomer(id).orElseThrow();
		CustomerDTO customerDTO = objectMapper.convertValue(customer, CustomerDTO.class);
		return ResponseEntity.ok().body(customerDTO);
	}

	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO){
		Customer customer = new Customer();
		customer.setFavorites(customerDTO.getFavorites());
		customer.setTelephone(customerDTO.getTelephone());

		return ResponseEntity.created(URI.create("/customers/"+customerService.createCustomer(customer).getId())).build();
	}

	@PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody JsonPatch patch){
		try {
			Customer customer = customerService.findCustomer(id).orElseThrow();
			Customer customerPatched = applyPatchToCustomer(patch, customer);
			customerService.updateCustomer(customerPatched);
			return ResponseEntity.ok(customerPatched);
		} catch (JsonPatchException | JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	private Customer applyPatchToCustomer(
		JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {
		JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
		return objectMapper.treeToValue(patched, Customer.class);
	}
}
