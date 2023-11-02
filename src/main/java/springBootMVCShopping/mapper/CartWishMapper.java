package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.CartDTO;
import springBootMVCShopping.domain.GoodsDTO;

@Mapper
public interface CartWishMapper {
	public List<GoodsDTO> goodsSelectAll(String goodsNum);
	public Integer wishGoodsSelect(String goodsNum,String memberNum);
	public Integer wishInsert(String goodsNum,String memberNum);
	public Integer wishDelete(String goodsNum,String memberNum);
	public List<GoodsDTO> wishGoodsList(String memberNum);
	public int wishGoodsDelete(@Param("goodsNums") String wishGoodsDels[], @Param("memberNum")String memberNum);
	public int cartInsert(CartDTO dto);
	
}
