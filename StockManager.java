import java.util.ArrayList;
import java.util.Iterator;
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StockManager{
    // A list of the products.
    private ArrayList<Product> stock;
    /**
     * Initialise the stock manager.
     */
    public StockManager(){
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item){
        boolean found = false;
        Product goods = null;
        Iterator<Product> iterador = stock.iterator();
        while (iterador.hasNext() && !found){
            goods = iterador.next();
            if(goods.getID() == item.getID()){
                found = true;
                System.out.println("ERROR: Ese identificador de producto ya existe");
            }
        }
        if (!found){
            stock.add(item);
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount){
        Iterator<Product> iterador = stock.iterator();
        Product producto = null;
        boolean found = false;
        while (iterador.hasNext() && !found){
            producto = iterador.next();
            if(producto.getID() == id){
                producto.increaseQuantity(amount);
                System.out.println("Las unidades se intentan agregar... Hecho");
                found = true;
            }
        }
        if (!found){
            System.out.println("ERROR: Ese producto no existe");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * with a matching ID.
     */
    public Product findProduct(int id){
        boolean found = false;
        Product productFound = null;
        Product temporalProduct = null;
        Iterator<Product> iterador = stock.iterator();
        while (iterador.hasNext() && !found){
            temporalProduct = iterador.next();
            if (id == temporalProduct.getID()){
                productFound = temporalProduct;
                found = true;
            }
        }
        return productFound;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id){
        int stockNumber = 0;
        Iterator<Product> iterador = stock.iterator();
        Product producto = null;
        boolean found = false;
        while (iterador.hasNext() && !found){
            producto = iterador.next();
            if(producto.getID() == id){
                stockNumber = producto.getQuantity();
                found = true;
            }
        }
        return stockNumber;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails(){
        for (Product goods : stock){
            System.out.println(goods.toString());
        }
    }
    
    /**
     * Imprime los detalles de los objetos de los que hay menos unidades de las indicadas
     */
    public void stockLow(int cantidad){
        for (Product goods : stock){
            if(goods.getQuantity() < cantidad){
                System.out.println(goods.toString());
            }
        }
    }
    
    /**
     * Busca productos por su nombre
     */
    public Product findProduct(String name){
        Boolean found = false;
        Product encontrado = null;
        Product temporal = null;
        Iterator<Product> iterador = stock.iterator();
        while (iterador.hasNext() && !found){
            temporal = iterador.next();
            if(temporal.getName().equals(name)){
                encontrado = temporal;
                found = true;
            }
        }
        return encontrado;
    }
}