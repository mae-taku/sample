package com.example.demo.hello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hello.domain.user.entity.HidukeForm;
import com.example.demo.hello.domain.user.entity.HidukeOutForm;

@Service
public class DateCalcService {

	@Autowired
	private UserMapper userMapper;

//	READ
	public ArrayList<HidukeOutForm> selectAllDate(LocalDate date){
		List<HidukeForm> list = userMapper.selectAllDate();//Mapperからのデータをリストに格納。

//		LocalDate a = list.get(0).getLocalDate();
//		System.out.println(a);
//		HidukeForm b = list.get(0);//list内のHidukeFormをインスタンス化して取り出す
//		System.out.println(b);	
		
        ArrayList<HidukeOutForm> listForm = new ArrayList<HidukeOutForm>();//空のリストを作成

        for (int i = 0; i < list.size(); i++) {
            HidukeOutForm outForm = new HidukeOutForm();//リストに格納する出力データフォーマットをインスタンス化。
            //以下で、mapperリストの各データを出力フォーマットへ入れ替え。HidukeForm -> HidukeOutForm
    		outForm.setId(list.get(i).getId());
    		outForm.setHidukeId(list.get(i).getHidukeId());
    		outForm.setHidukeName(list.get(i).getHidukeName());
    		outForm.setDate(list.get(i).calcDate());

//    		LocalDate date = LocalDate.of(2021, 10, 7);//サンプルデータ ->入力値を入れるように変更予定

//    		計算処理ロジック。基準日にリストからとってきた加減値を足す。
    		LocalDate resultDate = date.plusYears(list.get(i).getCountYear())
    				.plusMonths(list.get(i).getCountMonth())
    				.plusDays(list.get(i).getCountDay());
    		outForm.setResultDate(resultDate);//出力用フォーマットに計算結果を入れる。
    		
    		//出力データフォーマットをリストに格納。
    		listForm.add(outForm);
        } 
        
		return listForm;
	}
	
//	CREATE
	public void insert(HidukeForm newOne) {
		userMapper.insertHiduke(newOne);
		}
//	UPDATE
//	DELETE
}
