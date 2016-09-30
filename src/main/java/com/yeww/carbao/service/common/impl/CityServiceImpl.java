package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.dao.common.CityMapper;
import com.yeww.carbao.domain.response.common.CityQueryResponse;
import com.yeww.carbao.model.common.CityEntiity;
import com.yeww.carbao.service.common.ICityService;
import com.yeww.carbao.utils.ChineseToEnglishUtil;
import com.yeww.carbao.utils.JsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
@Service
public class CityServiceImpl implements ICityService {


    @Resource
    private CityMapper cityMapper;

    @Override
    public void init() {
        String city = "{citycode:[{s1:\"北京\",s2:[{name:\"北京\",code:\"101010100\"},{name:\"朝阳\",code:\"101010300\"},{name:\"顺义\",code:\"101010400\"},{name:\"怀柔\",code:\"101010500\"},{name:\"通州\",code:\"101010600\"},{name:\"昌平\",code:\"101010700\"},{name:\"延庆\",code:\"101010800\"},{name:\"丰台\",code:\"101010900\"},{name:\"石景山\",code:\"101011000\"},{name:\"大兴\",code:\"101011100\"},{name:\"房山\",code:\"101011200\"},{name:\"密云\",code:\"101011300\"},{name:\"门头沟\",code:\"101011400\"},{name:\"平谷\",code:\"101011500\"},{name:\"八达岭\",code:\"101011600\"},{name:\"佛爷顶\",code:\"101011700\"},{name:\"汤河口\",code:\"101011800\"},{name:\"密云上甸子\",code:\"101011900\"},{name:\"斋堂\",code:\"101012000\"},{name:\"霞云岭\",code:\"101012100\"},{name:\"北京城区\",code:\"101012200\"},{name:\"海淀\",code:\"101010200\"}]},{s1:\"天津\",s2:[{name:\"天津\",code:\"101030100\"},{name:\"宝坻\",code:\"101030300\"},{name:\"东丽\",code:\"101030400\"},{name:\"西青\",code:\"101030500\"},{name:\"北辰\",code:\"101030600\"},{name:\"蓟县\",code:\"101031400\"},{name:\"汉沽\",code:\"101030800\"},{name:\"静海\",code:\"101030900\"},{name:\"津南\",code:\"101031000\"},{name:\"塘沽\",code:\"101031100\"},{name:\"大港\",code:\"101031200\"},{name:\"武清\",code:\"101030200\"},{name:\"宁河\",code:\"101030700\"}]},{s1:\"上海\",s2:[{name:\"上海\",code:\"101020100\"},{name:\"宝山\",code:\"101020300\"},{name:\"嘉定\",code:\"101020500\"},{name:\"南汇\",code:\"101020600\"},{name:\"浦东\",code:\"101021300\"},{name:\"青浦\",code:\"101020800\"},{name:\"松江\",code:\"101020900\"},{name:\"奉贤\",code:\"101021000\"},{name:\"崇明\",code:\"101021100\"},{name:\"徐家汇\",code:\"101021200\"},{name:\"闵行\",code:\"101020200\"},{name:\"金山\",code:\"101020700\"}]},{s1:\"河北\",s2:[{name:\"石家庄\",code:\"101090101\"},{name:\"张家口\",code:\"101090301\"},{name:\"承德\",code:\"101090402\"},{name:\"唐山\",code:\"101090501\"},{name:\"秦皇岛\",code:\"101091101\"},{name:\"沧州\",code:\"101090701\"},{name:\"衡水\",code:\"101090801\"},{name:\"邢台\",code:\"101090901\"},{name:\"邯郸\",code:\"101091001\"},{name:\"保定\",code:\"101090201\"},{name:\"廊坊\",code:\"101090601\"}]},{s1:\"河南\",s2:[{name:\"郑州\",code:\"101180101\"},{name:\"新乡\",code:\"101180301\"},{name:\"许昌\",code:\"101180401\"},{name:\"平顶山\",code:\"101180501\"},{name:\"信阳\",code:\"101180601\"},{name:\"南阳\",code:\"101180701\"},{name:\"开封\",code:\"101180801\"},{name:\"洛阳\",code:\"101180901\"},{name:\"商丘\",code:\"101181001\"},{name:\"焦作\",code:\"101181101\"},{name:\"鹤壁\",code:\"101181201\"},{name:\"濮阳\",code:\"101181301\"},{name:\"周口\",code:\"101181401\"},{name:\"漯河\",code:\"101181501\"},{name:\"驻马店\",code:\"101181601\"},{name:\"三门峡\",code:\"101181701\"},{name:\"济源\",code:\"101181801\"},{name:\"安阳\",code:\"101180201\"}]},{s1:\"安徽\",s2:[{name:\"合肥\",code:\"101220101\"},{name:\"芜湖\",code:\"101220301\"},{name:\"淮南\",code:\"101220401\"},{name:\"马鞍山\",code:\"101220501\"},{name:\"安庆\",code:\"101220601\"},{name:\"宿州\",code:\"101220701\"},{name:\"阜阳\",code:\"101220801\"},{name:\"亳州\",code:\"101220901\"},{name:\"黄山\",code:\"101221001\"},{name:\"滁州\",code:\"101221101\"},{name:\"淮北\",code:\"101221201\"},{name:\"铜陵\",code:\"101221301\"},{name:\"宣城\",code:\"101221401\"},{name:\"六安\",code:\"101221501\"},{name:\"巢湖\",code:\"101221601\"},{name:\"池州\",code:\"101221701\"},{name:\"蚌埠\",code:\"101220201\"}]},{s1:\"浙江\",s2:[{name:\"杭州\",code:\"101210101\"},{name:\"舟山\",code:\"101211101\"},{name:\"湖州\",code:\"101210201\"},{name:\"嘉兴\",code:\"101210301\"},{name:\"金华\",code:\"101210901\"},{name:\"绍兴\",code:\"101210501\"},{name:\"台州\",code:\"101210601\"},{name:\"温州\",code:\"101210701\"},{name:\"丽水\",code:\"101210801\"},{name:\"衢州\",code:\"101211001\"},{name:\"宁波\",code:\"101210401\"}]},{s1:\"重庆\",s2:[{name:\"重庆\",code:\"101040100\"},{name:\"合川\",code:\"101040300\"},{name:\"南川\",code:\"101040400\"},{name:\"江津\",code:\"101040500\"},{name:\"万盛\",code:\"101040600\"},{name:\"渝北\",code:\"101040700\"},{name:\"北碚\",code:\"101040800\"},{name:\"巴南\",code:\"101040900\"},{name:\"长寿\",code:\"101041000\"},{name:\"黔江\",code:\"101041100\"},{name:\"万州天城\",code:\"101041200\"},{name:\"万州龙宝\",code:\"101041300\"},{name:\"涪陵\",code:\"101041400\"},{name:\"开县\",code:\"101041500\"},{name:\"城口\",code:\"101041600\"},{name:\"云阳\",code:\"101041700\"},{name:\"巫溪\",code:\"101041800\"},{name:\"奉节\",code:\"101041900\"},{name:\"巫山\",code:\"101042000\"},{name:\"潼南\",code:\"101042100\"},{name:\"垫江\",code:\"101042200\"},{name:\"梁平\",code:\"101042300\"},{name:\"忠县\",code:\"101042400\"},{name:\"石柱\",code:\"101042500\"},{name:\"大足\",code:\"101042600\"},{name:\"荣昌\",code:\"101042700\"},{name:\"铜梁\",code:\"101042800\"},{name:\"璧山\",code:\"101042900\"},{name:\"丰都\",code:\"101043000\"},{name:\"武隆\",code:\"101043100\"},{name:\"彭水\",code:\"101043200\"},{name:\"綦江\",code:\"101043300\"},{name:\"酉阳\",code:\"101043400\"},{name:\"秀山\",code:\"101043600\"},{name:\"沙坪坝\",code:\"101043700\"},{name:\"永川\",code:\"101040200\"}]},{s1:\"福建\",s2:[{name:\"福州\",code:\"101230101\"},{name:\"泉州\",code:\"101230501\"},{name:\"漳州\",code:\"101230601\"},{name:\"龙岩\",code:\"101230701\"},{name:\"晋江\",code:\"101230509\"},{name:\"南平\",code:\"101230901\"},{name:\"厦门\",code:\"101230201\"},{name:\"宁德\",code:\"101230301\"},{name:\"莆田\",code:\"101230401\"},{name:\"三明\",code:\"101230801\"}]},{s1:\"甘肃\",s2:[{name:\"兰州\",code:\"101160101\"},{name:\"平凉\",code:\"101160301\"},{name:\"庆阳\",code:\"101160401\"},{name:\"武威\",code:\"101160501\"},{name:\"金昌\",code:\"101160601\"},{name:\"嘉峪关\",code:\"101161401\"},{name:\"酒泉\",code:\"101160801\"},{name:\"天水\",code:\"101160901\"},{name:\"武都\",code:\"101161001\"},{name:\"临夏\",code:\"101161101\"},{name:\"合作\",code:\"101161201\"},{name:\"白银\",code:\"101161301\"},{name:\"定西\",code:\"101160201\"},{name:\"张掖\",code:\"101160701\"}]},{s1:\"广东\",s2:[{name:\"广州\",code:\"101280101\"},{name:\"惠州\",code:\"101280301\"},{name:\"梅州\",code:\"101280401\"},{name:\"汕头\",code:\"101280501\"},{name:\"深圳\",code:\"101280601\"},{name:\"珠海\",code:\"101280701\"},{name:\"佛山\",code:\"101280800\"},{name:\"肇庆\",code:\"101280901\"},{name:\"湛江\",code:\"101281001\"},{name:\"江门\",code:\"101281101\"},{name:\"河源\",code:\"101281201\"},{name:\"清远\",code:\"101281301\"},{name:\"云浮\",code:\"101281401\"},{name:\"潮州\",code:\"101281501\"},{name:\"东莞\",code:\"101281601\"},{name:\"中山\",code:\"101281701\"},{name:\"阳江\",code:\"101281801\"},{name:\"揭阳\",code:\"101281901\"},{name:\"茂名\",code:\"101282001\"},{name:\"汕尾\",code:\"101282101\"},{name:\"韶关\",code:\"101280201\"}]},{s1:\"广西\",s2:[{name:\"南宁\",code:\"101300101\"},{name:\"柳州\",code:\"101300301\"},{name:\"来宾\",code:\"101300401\"},{name:\"桂林\",code:\"101300501\"},{name:\"梧州\",code:\"101300601\"},{name:\"防城港\",code:\"101301401\"},{name:\"贵港\",code:\"101300801\"},{name:\"玉林\",code:\"101300901\"},{name:\"百色\",code:\"101301001\"},{name:\"钦州\",code:\"101301101\"},{name:\"河池\",code:\"101301201\"},{name:\"北海\",code:\"101301301\"},{name:\"崇左\",code:\"101300201\"},{name:\"贺州\",code:\"101300701\"}]},{s1:\"贵州\",s2:[{name:\"贵阳\",code:\"101260101\"},{name:\"安顺\",code:\"101260301\"},{name:\"都匀\",code:\"101260401\"},{name:\"兴义\",code:\"101260906\"},{name:\"铜仁\",code:\"101260601\"},{name:\"毕节\",code:\"101260701\"},{name:\"六盘水\",code:\"101260801\"},{name:\"遵义\",code:\"101260201\"},{name:\"凯里\",code:\"101260501\"}]},{s1:\"云南\",s2:[{name:\"昆明\",code:\"101290101\"},{name:\"红河\",code:\"101290301\"},{name:\"文山\",code:\"101290601\"},{name:\"玉溪\",code:\"101290701\"},{name:\"楚雄\",code:\"101290801\"},{name:\"普洱\",code:\"101290901\"},{name:\"昭通\",code:\"101291001\"},{name:\"临沧\",code:\"101291101\"},{name:\"怒江\",code:\"101291201\"},{name:\"香格里拉\",code:\"101291301\"},{name:\"丽江\",code:\"101291401\"},{name:\"德宏\",code:\"101291501\"},{name:\"景洪\",code:\"101291601\"},{name:\"大理\",code:\"101290201\"},{name:\"曲靖\",code:\"101290401\"},{name:\"保山\",code:\"101290501\"}]},{s1:\"内蒙古\",s2:[{name:\"呼和浩特\",code:\"101080101\"},{name:\"乌海\",code:\"101080301\"},{name:\"集宁\",code:\"101080401\"},{name:\"通辽\",code:\"101080501\"},{name:\"阿拉善左旗\",code:\"101081201\"},{name:\"鄂尔多斯\",code:\"101080701\"},{name:\"临河\",code:\"101080801\"},{name:\"锡林浩特\",code:\"101080901\"},{name:\"呼伦贝尔\",code:\"101081000\"},{name:\"乌兰浩特\",code:\"101081101\"},{name:\"包头\",code:\"101080201\"},{name:\"赤峰\",code:\"101080601\"}]},{s1:\"江西\",s2:[{name:\"南昌\",code:\"101240101\"},{name:\"上饶\",code:\"101240301\"},{name:\"抚州\",code:\"101240401\"},{name:\"宜春\",code:\"101240501\"},{name:\"鹰潭\",code:\"101241101\"},{name:\"赣州\",code:\"101240701\"},{name:\"景德镇\",code:\"101240801\"},{name:\"萍乡\",code:\"101240901\"},{name:\"新余\",code:\"101241001\"},{name:\"九江\",code:\"101240201\"},{name:\"吉安\",code:\"101240601\"}]},{s1:\"湖北\",s2:[{name:\"武汉\",code:\"101200101\"},{name:\"黄冈\",code:\"101200501\"},{name:\"荆州\",code:\"101200801\"},{name:\"宜昌\",code:\"101200901\"},{name:\"恩施\",code:\"101201001\"},{name:\"十堰\",code:\"101201101\"},{name:\"神农架\",code:\"101201201\"},{name:\"随州\",code:\"101201301\"},{name:\"荆门\",code:\"101201401\"},{name:\"天门\",code:\"101201501\"},{name:\"仙桃\",code:\"101201601\"},{name:\"潜江\",code:\"101201701\"},{name:\"襄樊\",code:\"101200201\"},{name:\"鄂州\",code:\"101200301\"},{name:\"孝感\",code:\"101200401\"},{name:\"黄石\",code:\"101200601\"},{name:\"咸宁\",code:\"101200701\"}]},{s1:\"四川\",s2:[{name:\"成都\",code:\"101270101\"},{name:\"自贡\",code:\"101270301\"},{name:\"绵阳\",code:\"101270401\"},{name:\"南充\",code:\"101270501\"},{name:\"达州\",code:\"101270601\"},{name:\"遂宁\",code:\"101270701\"},{name:\"广安\",code:\"101270801\"},{name:\"巴中\",code:\"101270901\"},{name:\"泸州\",code:\"101271001\"},{name:\"宜宾\",code:\"101271101\"},{name:\"内江\",code:\"101271201\"},{name:\"资阳\",code:\"101271301\"},{name:\"乐山\",code:\"101271401\"},{name:\"眉山\",code:\"101271501\"},{name:\"凉山\",code:\"101271601\"},{name:\"雅安\",code:\"101271701\"},{name:\"甘孜\",code:\"101271801\"},{name:\"阿坝\",code:\"101271901\"},{name:\"德阳\",code:\"101272001\"},{name:\"广元\",code:\"101272101\"},{name:\"攀枝花\",code:\"101270201\"}]},{s1:\"宁夏\",s2:[{name:\"银川\",code:\"101170101\"},{name:\"中卫\",code:\"101170501\"},{name:\"固原\",code:\"101170401\"},{name:\"石嘴山\",code:\"101170201\"},{name:\"吴忠\",code:\"101170301\"}]},{s1:\"青海\",s2:[{name:\"西宁\",code:\"101150101\"},{name:\"黄南\",code:\"101150301\"},{name:\"海北\",code:\"101150801\"},{name:\"果洛\",code:\"101150501\"},{name:\"玉树\",code:\"101150601\"},{name:\"海西\",code:\"101150701\"},{name:\"海东\",code:\"101150201\"},{name:\"海南\",code:\"101150401\"}]},{s1:\"山东\",s2:[{name:\"济南\",code:\"101120101\"},{name:\"潍坊\",code:\"101120601\"},{name:\"临沂\",code:\"101120901\"},{name:\"菏泽\",code:\"101121001\"},{name:\"滨州\",code:\"101121101\"},{name:\"东营\",code:\"101121201\"},{name:\"威海\",code:\"101121301\"},{name:\"枣庄\",code:\"101121401\"},{name:\"日照\",code:\"101121501\"},{name:\"莱芜\",code:\"101121601\"},{name:\"聊城\",code:\"101121701\"},{name:\"青岛\",code:\"101120201\"},{name:\"淄博\",code:\"101120301\"},{name:\"德州\",code:\"101120401\"},{name:\"烟台\",code:\"101120501\"},{name:\"济宁\",code:\"101120701\"},{name:\"泰安\",code:\"101120801\"}]},{s1:\"陕西\",s2:[{name:\"西安\",code:\"101110101\"},{name:\"延安\",code:\"101110300\"},{name:\"榆林\",code:\"101110401\"},{name:\"铜川\",code:\"101111001\"},{name:\"商洛\",code:\"101110601\"},{name:\"安康\",code:\"101110701\"},{name:\"汉中\",code:\"101110801\"},{name:\"宝鸡\",code:\"101110901\"},{name:\"咸阳\",code:\"101110200\"},{name:\"渭南\",code:\"101110501\"}]},{s1:\"山西\",s2:[{name:\"太原\",code:\"101100101\"},{name:\"临汾\",code:\"101100701\"},{name:\"运城\",code:\"101100801\"},{name:\"朔州\",code:\"101100901\"},{name:\"忻州\",code:\"101101001\"},{name:\"长治\",code:\"101100501\"},{name:\"大同\",code:\"101100201\"},{name:\"阳泉\",code:\"101100301\"},{name:\"晋中\",code:\"101100401\"},{name:\"晋城\",code:\"101100601\"},{name:\"吕梁\",code:\"101101100\"}]},{s1:\"新疆\",s2:[{name:\"乌鲁木齐\",code:\"101130101\"},{name:\"石河子\",code:\"101130301\"},{name:\"昌吉\",code:\"101130401\"},{name:\"吐鲁番\",code:\"101130501\"},{name:\"库尔勒\",code:\"101130601\"},{name:\"阿拉尔\",code:\"101130701\"},{name:\"阿克苏\",code:\"101130801\"},{name:\"喀什\",code:\"101130901\"},{name:\"伊宁\",code:\"101131001\"},{name:\"塔城\",code:\"101131101\"},{name:\"哈密\",code:\"101131201\"},{name:\"和田\",code:\"101131301\"},{name:\"阿勒泰\",code:\"101131401\"},{name:\"阿图什\",code:\"101131501\"},{name:\"博乐\",code:\"101131601\"},{name:\"克拉玛依\",code:\"101130201\"}]},{s1:\"西藏\",s2:[{name:\"拉萨\",code:\"101140101\"},{name:\"山南\",code:\"101140301\"},{name:\"阿里\",code:\"101140701\"},{name:\"昌都\",code:\"101140501\"},{name:\"那曲\",code:\"101140601\"},{name:\"日喀则\",code:\"101140201\"},{name:\"林芝\",code:\"101140401\"}]},{s1:\"台湾\",s2:[{name:\"台北县\",code:\"101340101\"},{name:\"高雄\",code:\"101340201\"},{name:\"台中\",code:\"101340401\"}]},{s1:\"海南省\",s2:[{name:\"海口\",code:\"101310101\"},{name:\"三亚\",code:\"101310201\"},{name:\"东方\",code:\"101310202\"},{name:\"临高\",code:\"101310203\"},{name:\"澄迈\",code:\"101310204\"},{name:\"儋州\",code:\"101310205\"},{name:\"昌江\",code:\"101310206\"},{name:\"白沙\",code:\"101310207\"},{name:\"琼中\",code:\"101310208\"},{name:\"定安\",code:\"101310209\"},{name:\"屯昌\",code:\"101310210\"},{name:\"琼海\",code:\"101310211\"},{name:\"文昌\",code:\"101310212\"},{name:\"保亭\",code:\"101310214\"},{name:\"万宁\",code:\"101310215\"},{name:\"陵水\",code:\"101310216\"},{name:\"西沙\",code:\"101310217\"},{name:\"南沙岛\",code:\"101310220\"},{name:\"乐东\",code:\"101310221\"},{name:\"五指山\",code:\"101310222\"},{name:\"琼山\",code:\"101310102\"}]},{s1:\"湖南\",s2:[{name:\"长沙\",code:\"101250101\"},{name:\"株洲\",code:\"101250301\"},{name:\"衡阳\",code:\"101250401\"},{name:\"郴州\",code:\"101250501\"},{name:\"常德\",code:\"101250601\"},{name:\"益阳\",code:\"101250700\"},{name:\"娄底\",code:\"101250801\"},{name:\"邵阳\",code:\"101250901\"},{name:\"岳阳\",code:\"101251001\"},{name:\"张家界\",code:\"101251101\"},{name:\"怀化\",code:\"101251201\"},{name:\"黔阳\",code:\"101251301\"},{name:\"永州\",code:\"101251401\"},{name:\"吉首\",code:\"101251501\"},{name:\"湘潭\",code:\"101250201\"}]},{s1:\"江苏\",s2:[{name:\"南京\",code:\"101190101\"},{name:\"镇江\",code:\"101190301\"},{name:\"苏州\",code:\"101190401\"},{name:\"南通\",code:\"101190501\"},{name:\"扬州\",code:\"101190601\"},{name:\"宿迁\",code:\"101191301\"},{name:\"徐州\",code:\"101190801\"},{name:\"淮安\",code:\"101190901\"},{name:\"连云港\",code:\"101191001\"},{name:\"常州\",code:\"101191101\"},{name:\"泰州\",code:\"101191201\"},{name:\"无锡\",code:\"101190201\"},{name:\"盐城\",code:\"101190701\"}]},{s1:\"黑龙江\",s2:[{name:\"哈尔滨\",code:\"101050101\"},{name:\"牡丹江\",code:\"101050301\"},{name:\"佳木斯\",code:\"101050401\"},{name:\"绥化\",code:\"101050501\"},{name:\"黑河\",code:\"101050601\"},{name:\"双鸭山\",code:\"101051301\"},{name:\"伊春\",code:\"101050801\"},{name:\"大庆\",code:\"101050901\"},{name:\"七台河\",code:\"101051002\"},{name:\"鸡西\",code:\"101051101\"},{name:\"鹤岗\",code:\"101051201\"},{name:\"齐齐哈尔\",code:\"101050201\"},{name:\"大兴安岭\",code:\"101050701\"}]},{s1:\"吉林\",s2:[{name:\"长春\",code:\"101060101\"},{name:\"延吉\",code:\"101060301\"},{name:\"四平\",code:\"101060401\"},{name:\"白山\",code:\"101060901\"},{name:\"白城\",code:\"101060601\"},{name:\"辽源\",code:\"101060701\"},{name:\"松原\",code:\"101060801\"},{name:\"吉林\",code:\"101060201\"},{name:\"通化\",code:\"101060501\"}]},{s1:\"辽宁\",s2:[{name:\"沈阳\",code:\"101070101\"},{name:\"鞍山\",code:\"101070301\"},{name:\"抚顺\",code:\"101070401\"},{name:\"本溪\",code:\"101070501\"},{name:\"丹东\",code:\"101070601\"},{name:\"葫芦岛\",code:\"101071401\"},{name:\"营口\",code:\"101070801\"},{name:\"阜新\",code:\"101070901\"},{name:\"辽阳\",code:\"101071001\"},{name:\"铁岭\",code:\"101071101\"},{name:\"朝阳\",code:\"101071201\"},{name:\"盘锦\",code:\"101071301\"},{name:\"大连\",code:\"101070201\"},{name:\"锦州\",code:\"101070701\"}]}]}";
        try {
            Map<String, Object> data = JsonUtil.toMap(city);
            System.out.println(data);
            List<Map> cityList = (List<Map>) data.get("citycode");
            for (Map map : cityList) {
                CityEntiity entiity = new CityEntiity();
                String pre = (String) map.get("s1");
                entiity.setPid(-1l);
                entiity.setCityCode("");
                entiity.setCityName(pre);
                entiity.setCityZh(ChineseToEnglishUtil.getPingYin(entiity.getCityName()));
                entiity.setCityType("s1");
                entiity.setCreateTime(new Date());
                cityMapper.insert(entiity);

                List<Map> subCityList = (List<Map>) map.get("s2");
                for (Map s : subCityList) {
                    CityEntiity d = new CityEntiity();
                    d.setPid(entiity.getId());
                    d.setCityCode((String) s.get("code"));
                    d.setCityName((String) s.get("name"));
                    d.setCityZh(ChineseToEnglishUtil.getPingYin(d.getCityName()));
                    d.setCityType("s2");
                    d.setCreateTime(new Date());
                    cityMapper.insert(d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<CityQueryResponse> getCityInfo() {
        Map map = new HashMap();
        map.put("cityType", "s2");
        List<CityEntiity> all = cityMapper.selectAll(map);
        if (CollectionUtils.isEmpty(all)) {
            return null;
        }
        List<CityQueryResponse> list = new ArrayList<CityQueryResponse>(all.size());
        CityQueryResponse response = null;
        for (CityEntiity entiity : all) {
            response = new CityQueryResponse();
            response.converter(entiity);
            list.add(response);
        }
        return list;
    }

    @Override
    public CityEntiity selectById(Long id) {
        return cityMapper.selectById(id);
    }
}
