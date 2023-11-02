package springBootMVCShopping.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.CartWishMapper;
import springBootMVCShopping.mapper.MemberMyMapper;

@Service
public class MainGoodsListService {
	@Autowired
	CartWishMapper cartWishMapper;
	@Autowired
	MemberMyMapper memberMyMapper;
	public void execute(String goodsNum,Model model, HttpSession session) {
		List<GoodsDTO> list = cartWishMapper.goodsSelectAll(goodsNum);
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");		
		if(auth != null) {
			if(auth.getGrade().equals("mem")) {
				MemberDTO dto = memberMyMapper.memberInfo(auth.getUserId());
				Integer i = cartWishMapper.wishGoodsSelect(goodsNum, dto.getMemberNum());
				model.addAttribute("wish", i);
			}
		}		
		model.addAttribute("list",list);
	}
}
