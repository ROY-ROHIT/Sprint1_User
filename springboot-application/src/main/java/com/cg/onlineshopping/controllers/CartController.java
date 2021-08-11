//package com.cg.onlineshopping.controllers;
//
//  
//  import java.util.List;
//  
//  import org.springframework.beans.factory.annotation.Autowired; import
//  org.springframework.http.HttpStatus; import
//  org.springframework.http.ResponseEntity; import
//  org.springframework.web.bind.annotation.DeleteMapping; import
//  org.springframework.web.bind.annotation.GetMapping; import
//  org.springframework.web.bind.annotation.PathVariable; import
//  org.springframework.web.bind.annotation.PostMapping; import
//  org.springframework.web.bind.annotation.PutMapping; import
//  org.springframework.web.bind.annotation.RequestBody; import
//  org.springframework.web.bind.annotation.RestController;
//
//import com.cg.onlineshopping.services.ICartService;
//  
//  
//  @RestController public class CartController {
//  
//  
//  @Autowired private ICartService Cart;
//  
//  @GetMapping("/cart/allproducts") // public List<Product>
//  RetrieveAllProdInCart(@RequestBody Cart cr) // { // return
//  Cart.viewAllProducts(cr); // }
//  
//  @GetMapping("/cart/allproducts/{id}") public List<ProductList>
//  RetrieveAllProdInCart(@PathVariable("id") int id) { return
//  Cart.viewAllProducts(id); }
//  
//  @PostMapping("/cart/addproduct/{prodId}/{quantity}") public
//  ResponseEntity<Cart> AddProductToCart (@PathVariable("prodId") int
//  prodId,@PathVariable("quantity")int quantity, @RequestBody Cart cr) { Cart
//  savedCart = Cart.addProductToCart(cr,prodId,quantity); return new
//  ResponseEntity<>(savedCart,HttpStatus.CREATED); }
//  
//  @DeleteMapping("/cart/remove/{prodId}") public void
//  RemoveProduct(@RequestBody Cart cr,@PathVariable("prodId") int prodId) {
//  Cart.removeProductFromCart(cr,prodId); }
//  
//  @DeleteMapping("/cart/removeall/{Id}") public void
//  RemoveAllProduct(@PathVariable("Id") int Id) { Cart.removeAllProducts(Id); }
//  
//  @PutMapping("/cart/updateproduct/{id}/{name}/{quantity}") public ProductList
//  updateQuantity(@PathVariable("id") int id,@PathVariable("name") String
//  name,@PathVariable("quantity") int quantity) { return
//  Cart.updateProductQuantity(id,name,quantity); }
//  
//  }
// 