package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.corner.CartInsertService;
import springBootMVCShopping.service.corner.GoodsWishListService;
import springBootMVCShopping.service.corner.GoodsWishService;
import springBootMVCShopping.service.corner.WishDelService;
import springBootMVCShopping.service.corner.WishGoodsDelsService;
import springBootMVCShopping.service.goods.MainGoodsListService;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	MainGoodsListService mainGoodsListService;
	@Autowired
	GoodsWishService goodsWishService;
	@Autowired
	GoodsWishListService goodsWishListService;
	@Autowired
	WishGoodsDelsService wishGoodsDelsService;
	@Autowired
	WishDelService wishDelService;
	@Autowired
	CartInsertService cartInsertService;
	@GetMapping("detailView/{goodsNum}")
	public String prodInfo(@PathVariable("goodsNum") String goodsNum, Model model, HttpSession session) {
		mainGoodsListService.execute(goodsNum, model, session);
		return "thymeleaf/corner/detailView";
	}
	@RequestMapping(value="goodsWishAdd", method=RequestMethod.POST)
	public @ResponseBody String goodsWiShAdd(@RequestParam("goodsNum") String goodsNum, HttpSession session)	{
		return goodsWishService.execute(goodsNum, session);
	}
	@GetMapping("wishList")
	public String wishList(HttpSession session, Model model) {
		goodsWishListService.execute(session, model);
		return "thymeleaf/corner/wishList";
	}
	@PostMapping("goodsWishDels")
	public String goodsWishDels(@RequestParam("wishGoodsDel") String wishGoodsDels[], HttpSession session) {
		wishGoodsDelsService.execute(wishGoodsDels, session);
		return "redirect:wishList";
	}
	
	@GetMapping("wishDel")
	public String wishDel(@RequestParam("goodsNum") String goodsNum, HttpSession session) {
		wishDelService.execute(goodsNum, session);
		return "redirect:wishList";
	}
	@GetMapping("cartAdd")
	@ResponseBody
	public String cartAdd(@RequestParam(value="goodsNum") String goodsNum,
							@RequestParam(value="qty") Integer qty,HttpSession session) {
		
		return cartInsertService.execute(goodsNum, qty, session);
	}
	
	
	
	
}
