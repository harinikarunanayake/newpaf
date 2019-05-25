package springbootrestapiexample.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootrestapiexample.dao.SellerD;
import springbootrestapiexample.model.Seller;
@RestController
@RequestMapping("/company")
public class SellerController {
	
	
	@Autowired
	SellerD sellerD;
	/* SAVE AN EMPLOYEE */
	@PostMapping("/seller")
	public Seller createSeller(@Valid @RequestBody Seller sel) {
	return sellerD.save(sel);
	}
	/* GET ALL EMPLOYEES*/
	@GetMapping("/seller")
	public List<Seller> getAllSeller(){
	return sellerD.findAll();
	}
	/* GET EMPLOYEE BY ID */
	@GetMapping("/seller/{id}")
	public ResponseEntity<Seller> getSellerById(@PathVariable(value="id") Long
	id){
		
		Seller sel = sellerD.findOne(id);
	if(sel==null) {
	return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().body(sel);
	}
	
	/* UPDATE AN EMPLOYEE BY ID */
	@PutMapping("/seller/{id}")
	public ResponseEntity<Seller> updateEmployee(@PathVariable(value="id") Long id,
			
	@Valid @RequestBody Seller selDetails){
		
		Seller sel=sellerD.findOne(id);
		
	if(sel==null) {
	return ResponseEntity.notFound().build();
	}
	sel.setName(selDetails.getName());
	sel.setAddress(selDetails.getAddress());
	sel.setEmail(selDetails.getEmail());
	Seller updaSeller=sellerD.save(sel);
	return ResponseEntity.ok().body(updaSeller);
	}
	
	/*DELETE AN EMPLOYEE*/
	@DeleteMapping("/seller/{id}")
	public ResponseEntity<Seller> deleteSeller(@PathVariable(value="id") Long id){
		Seller sel = sellerD.findOne(id);
	if(sel==null) {
	return ResponseEntity.notFound().build();
	}
	sellerD.delete(sel);
	return ResponseEntity.ok().build();
	}
	
}
