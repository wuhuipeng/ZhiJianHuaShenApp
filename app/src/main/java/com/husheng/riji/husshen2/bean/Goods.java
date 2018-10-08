package com.husheng.riji.husshen2.bean;


import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Date coupon_start_time;  //优惠券开始时间

	private Date coupon_end_time; //优惠券结束时间

	private String info_dxjh; //定向计划信息（Json格式）

	private String tk_total_sales; //淘客30天月推广量

	private String tk_total_commi; //月支出佣金

	private String coupon_id;//优惠券ID

	private long num_iid;//宝贝id

	private String title;//商品标题

	private String pict_url; //商品主图

	private String[] small_images;//商品小图列表

	private float reserve_price;//商品一口价

	private float zk_final_price;//商品折扣价格

	private int user_type;//卖家类型

	private String provcity;//宝贝所在地

	private String item_url;//商品地址

	private String include_mkt;//是否包含营销计划

	private String include_dxjh;//是否包含定向计划

	private String commission_rate;//佣金比率

	private float commission_rate_value;//浮点型佣金比率

	private float estimateIncome;

	private long volume;//30天销量

	private long seller_id;//卖家id

	private int coupon_total_count;//优惠券总量

	private int coupon_remain_count;//优惠券剩余量

	private String coupon_info;//优惠券面额

	private String commission_type;//佣金类型

	private String shop_title;//店铺名称

	private int shop_dsr;//店铺dsr评分

	private String coupon_share_url;//券二合一页面链接

	private String url;//商品淘客链接

	private float coupon_value;

	private float coupon_after_price;


	public float getEstimateIncome() {
//		return estimateIncome;
		if(coupon_info != null && commission_rate != null)
			return coupon_after_price*commission_rate_value;

		return estimateIncome;
	}

	public void setEstimateIncome(float estimateIncome) {
		this.estimateIncome = estimateIncome;
	}

	public float getCoupon_value() {
		return coupon_value;
	}

	public void setCoupon_value(float coupon_value) {
		this.coupon_value = coupon_value;
	}

	public float getCoupon_after_price() {
		return coupon_after_price;
	}

	public void setCoupon_after_price(float coupon_after_price) {
		this.coupon_after_price = coupon_after_price;
	}

	public Date getCoupon_start_time() {
		return coupon_start_time;
	}

	public void setCoupon_start_time(Date coupon_start_time) {
		this.coupon_start_time = coupon_start_time;
	}

	public Date getCoupon_end_time() {
		return coupon_end_time;
	}

	public void setCoupon_end_time(Date coupon_end_time) {
		this.coupon_end_time = coupon_end_time;
	}

	public String getInfo_dxjh() {
		return info_dxjh;
	}

	public void setInfo_dxjh(String info_dxjh) {
		this.info_dxjh = info_dxjh;
	}

	public String getTk_total_sales() {
		return tk_total_sales;
	}

	public void setTk_total_sales(String tk_total_sales) {
		this.tk_total_sales = tk_total_sales;
	}

	public String getTk_total_commi() {
		return tk_total_commi;
	}

	public void setTk_total_commi(String tk_total_commi) {
		this.tk_total_commi = tk_total_commi;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public long getNum_iid() {
		return num_iid;
	}

	public void setNum_iid(long num_iid) {
		this.num_iid = num_iid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPict_url() {
		return pict_url;
	}

	public void setPict_url(String pict_url) {
		this.pict_url = pict_url;
	}

	public String[] getSmall_images() {
		return small_images;
	}

	public void setSmall_images(String[] small_images) {
		this.small_images = small_images;
	}



	public float getReserve_price() {
		return reserve_price;
	}

	public void setReserve_price(float reserve_price) {
		this.reserve_price = reserve_price;
	}

	public float getZk_final_price() {
		return zk_final_price;
	}

	public void setZk_final_price(float zk_final_price) {
		this.zk_final_price = zk_final_price;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getProvcity() {
		return provcity;
	}

	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}

	public String getItem_url() {
		return item_url;
	}

	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}

	public String getInclude_mkt() {
		return include_mkt;
	}

	public void setInclude_mkt(String include_mkt) {
		this.include_mkt = include_mkt;
	}

	public String getInclude_dxjh() {
		return include_dxjh;
	}

	public void setInclude_dxjh(String include_dxjh) {
		this.include_dxjh = include_dxjh;
	}

	public String getCommission_rate() {
		return commission_rate;
	}

	public void setCommission_rate(String commission_rate) {
		this.commission_rate = commission_rate;

		float tt = Float.parseFloat(this.commission_rate)*0.01f;

		this.commission_rate_value = (float)(Math.round(tt*10000))/10000;

//		double d = this.commission_rate_value;
//		System.out.println(this.commission_rate_value);
//		System.out.println(d);
//		long l = (long)(this.commission_rate_value*10000);
//		System.out.println(this.commission_rate_value);
//		System.out.println(Float.toString(this.commission_rate_value*10000));
//		System.out.println((long)(this.commission_rate_value*10000));
//		System.out.println(Long.toString((long)(this.commission_rate_value*10000)));
//		System.out.println(l);
	}

	public float getCommission_rate_value() {
		return commission_rate_value;
	}

	public void setCommission_rate_value(float commission_rate_value) {
		this.commission_rate_value = commission_rate_value;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}

	public int getCoupon_total_count() {
		return coupon_total_count;
	}

	public void setCoupon_total_count(int coupon_total_count) {
		this.coupon_total_count = coupon_total_count;
	}

	public int getCoupon_remain_count() {
		return coupon_remain_count;
	}

	public void setCoupon_remain_count(int coupon_remain_count) {
		this.coupon_remain_count = coupon_remain_count;
	}

	public String getCoupon_info() {
		return coupon_info;
	}

	public void setCoupon_info(String coupon_info) {
		this.coupon_info = coupon_info;

		if(this.coupon_info != null)
		{
			if(this.coupon_info.contains("无条件券"))
			{
				int index = this.coupon_info.indexOf("元无条件券");
				String vs = this.coupon_info.substring(0, index);

				this.coupon_value = Float.parseFloat(vs);

				this.coupon_after_price = this.zk_final_price-this.coupon_value;
			}
			else if(this.coupon_info.contains("满"))
			{
				int index = this.coupon_info.indexOf("减");

				String vs = this.coupon_info.substring(index+1, this.coupon_info.length()-1);
//				System.out.println(this.coupon_info);
//				System.out.println(vs);

				this.coupon_value = Float.parseFloat(vs);

				this.coupon_after_price = this.zk_final_price-this.coupon_value;
			}
		}

	}

	public String getCommission_type() {
		return commission_type;
	}

	public void setCommission_type(String commission_type) {
		this.commission_type = commission_type;
	}

	public String getShop_title() {
		return shop_title;
	}

	public void setShop_title(String shop_title) {
		this.shop_title = shop_title;
	}

	public int getShop_dsr() {
		return shop_dsr;
	}

	public void setShop_dsr(int shop_dsr) {
		this.shop_dsr = shop_dsr;
	}

	public String getCoupon_share_url() {
		return coupon_share_url;
	}

	public void setCoupon_share_url(String coupon_share_url) {
		this.coupon_share_url = coupon_share_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	class GoodsDeserializer extends JsonDeserializer<Goods> {
//
//        @Override
//        public Goods deserialize(JsonParser jp, DeserializationContext ctxt)
//          throws IOException, JsonProcessingException {
//            JsonNode node = jp.getCodec().readTree(jp);
//            int id = (Integer) ((IntNode) node.get("commission_rate")).numberValue();
//            String commission_rate = node.get("commission_rate").asText();
//
//            int userId = (Integer) ((IntNode) node.get("id")).numberValue();
//
//            return new Item(id, itemName, new User(userId, null));
//        }
//    }

//
//	public static void main(String[] args)
//	{
////		String str="{commission_rate:30, coupon_end_time:2018-08-13,coupon_info:满59.00元减20元,coupon_remain_count:46000,coupon_start_time:2018-08-06,coupon_total_count:50000}";
//
//		String t = "10";
//		int count = 4-t.length();
//		while(count>0)
//		{
//			t = t+"0";
//
//			count--;
//		}
//
//		System.out.println(t);
//
//		float tt = Float.parseFloat(t);
//
//		float b = (float)(Math.round(tt))/10000;
//
//		System.out.println(b);
//
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//
//		String str = "{commission_rate:30}";
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setDateFormat(sdf);
//
//		Goods student = null;
//		//			student = mapper.readValue(str, Goods.class);
//		//
//		//			if(student != null)
//		//				System.out.println(student.getCommission_rate());
//		//
//		student = new Goods();
//
//		//			student.setCommission_rate("30");
//		//			student.setCoupon_end_time(new Date());
//		//			student.setNum_iid(11111);
//		//			student.setZk_final_price(67.89f);
//		//			String[] css = {"满100减20"};
//		//			student.setCoupon_info(css);
//		//
//		//			String[] ss = {"rrr","ppp"};
//		//			student.setSmall_images(ss);
//
//		String c = "[{commission_rate:30, coupon_info:haha},"
//				+ "{commission_rate:30, coupon_info:aaa},"
//				+ "{commission_rate:30, coupon_info:[]}"
//				+ "]";//mapper.writeValueAsString(student);
//
//		System.out.println(c);
//
//		String pattern = "coupon_info:\\[\\]";
//
//		System.out.println(c.replaceAll(pattern, "coupon_info:null"));
//		System.out.println(student);
//
//	}
}
