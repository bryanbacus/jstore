import com.shenming.sms.dc.manager.SqlRuleManager;
import com.shenming.sms.module.hibernateOrm.SmTbSqlRule;


public class SqlRuleTest extends TestCaseAbstract{
	public static void main(String args[]){
		SqlRuleManager.initialize();
		
		SmTbSqlRule smTbSqlRule = new SmTbSqlRule();
		smTbSqlRule.setIdx(1);
		log(SqlRuleManager.getSmTbSqlRule(smTbSqlRule));
	}
	
	
}
