package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model){
        model.addAttribute("form",new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm bookForm){
        Book book = new Book();
        book.setName(bookForm.getName());
        book.setPrice(bookForm.getPrice());
        book.setStockQuantity(bookForm.getStockQuantity());
        book.setAuthor(bookForm.getAuthor());
        book.setIsbn(bookForm.getIsbn());

        itemService.saveItem(book);
        return "redirect:/";
    }

    @GetMapping("/items")
    public String itemList(Model model){
        List<Item> books = itemService.findByAll();
        model.addAttribute("items",books);
        return "/items/itemsList";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateForm(@PathVariable("itemId")Long itemId, Model model){
        Book item = (Book) itemService.findOne(itemId);
        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setAuthor(item.getAuthor());
        form.setStockQuantity(item.getStockQuantity());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form",form);
        return "/items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable("itemId")Long itemId, @ModelAttribute("form") BookForm bookForm){
//        Book book = new Book();
//        book.setName(bookForm.getName());
//        book.setPrice(bookForm.getPrice());
//        book.setAuthor(bookForm.getAuthor());
//        book.setStockQuantity(bookForm.getStockQuantity());
//        book.setIsbn(bookForm.getIsbn());
//        itemService.saveItem(book);

        itemService.updateItem(itemId,bookForm.getName(),bookForm.getPrice(),bookForm.getStockQuantity());
        return "redirect:/items";
    }
}
