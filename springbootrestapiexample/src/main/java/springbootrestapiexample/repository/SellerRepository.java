package springbootrestapiexample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import springbootrestapiexample.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}



