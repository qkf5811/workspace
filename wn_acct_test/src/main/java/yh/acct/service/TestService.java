package yh.acct.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.pri.j9.async.remote.ModuleRemoteResetLoader;
import net.pri.j9.framework.core.exception.LogicException;
import net.pri.j9.framework.loader.config.ConfigAbs;
import net.pri.j9.framework.remote.RemoteGateWayApi;
import net.pri.j9.framework.util.ConvertUtil;

@Service
public class TestService {

	private final static String api = "{\"010318\":{\"method\":\"queryCheckingDetail\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010103\":{\"method\":\"queryDepartment\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"}]},\"010104\":{\"method\":\"saveDepartment\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"}]},\"snapshot.store\":{\"method\":\"backupData\",\"class\":\"net.pri.j9.framework.core.log.api.DataSnapshotService\",\"paramData\":[{\"data\":\"Object\"},{\"table\":\"String\"}]},\"010311\":{\"method\":\"doConsum\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010301\":{\"method\":\"saveCardInfo\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010102\":{\"method\":\"saveMerchant\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"}]},\"log.store\":{\"method\":\"store\",\"class\":\"net.pri.j9.framework.core.log.api.GateWayLog\",\"paramData\":[{\"data\":\"EventLogRecode\"}]},\"010203\":{\"method\":\"savePatientBind\",\"class\":\"com.winning.acct.service.PatiService\",\"paramData\":[{\"data\":\"Map\"}]},\"010306\":{\"method\":\"queryTranstionDetail\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010312\":{\"method\":\"actionReversalConsum\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010313\":{\"method\":\"actionAdjustCredit\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"log.log4j\":{\"method\":\"log4j\",\"class\":\"net.pri.j9.framework.core.log.api.GateWayLog\",\"paramData\":[{\"data\":\"EventLogRecode\"}]},\"010101\":{\"method\":\"queryMerchant\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"}]},\"010107\":{\"method\":\"queryEmployeeByCode\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"}]},\"010307\":{\"method\":\"actionPreDaily\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010304\":{\"method\":\"cancelRecharge\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010314\":{\"method\":\"actionRepayment\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010201\":{\"method\":\"queryPatientInfo\",\"class\":\"com.winning.acct.service.PatiService\",\"paramData\":[{\"data\":\"Map\"}]},\"010202\":{\"method\":\"savePatientInfo\",\"class\":\"com.winning.acct.service.PatiService\",\"paramData\":[{\"data\":\"Map\"}]},\"010305\":{\"method\":\"queryTranstionMaster\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010302\":{\"method\":\"updateCardInfo\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010105\":{\"method\":\"queryEmployees\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"}]},\"010315\":{\"method\":\"actionImpBankData\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"time.now\":{\"method\":\"curTime\",\"class\":\"net.pri.j9.async.remote.service.TimeService\",\"paramData\":[]},\"010106\":{\"method\":\"saveEmployees\",\"class\":\"com.winning.acct.service.StdService\",\"paramData\":[{\"data\":\"Map\"},{\"merchantPkid\":\"Integer\"}]},\"010316\":{\"method\":\"actionImpAlipayData\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010204\":{\"method\":\"cancelPatientBind\",\"class\":\"com.winning.acct.service.PatiService\",\"paramData\":[{\"data\":\"Map\"}]},\"010317\":{\"method\":\"queryCheckingMaster\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"control.refreshSystemUrl\":{\"method\":\"refreshSystemUrl\",\"class\":\"net.pri.j9.async.remote.service.PassiveControlApi\",\"paramData\":[]},\"010308\":{\"method\":\"actionDaily\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"log.print\":{\"method\":\"print\",\"class\":\"net.pri.j9.framework.core.log.api.GateWayLog\",\"paramData\":[{\"data\":\"EventLogRecode\"}]},\"010310\":{\"method\":\"queryDailyDetail\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010303\":{\"method\":\"actionRecharge\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]},\"010309\":{\"method\":\"queryDailyMaster\",\"class\":\"com.winning.acct.service.AcctService\",\"paramData\":[{\"data\":\"Map\"}]}}";

	{

		// api
		Map<String, Map<String, Object>> apiMap = new Gson().fromJson(api,
				new TypeToken<Map<String, Map<String, Object>>>() {
				}.getType());
		System.out.println(apiMap);
	}

	public String doAction(Map param) throws LogicException {
		// 开启远程验证
		ModuleRemoteResetLoader n = new ModuleRemoteResetLoader();
		n.start(null, ConfigAbs.getConfig());

//		System.out.println(param);
//		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map root = new HashMap();
		root.put("data", param);
		String actionId = ConvertUtil.toString(param.get("actionId"));
//		System.out.println(actionId);
		Map resultMap = RemoteGateWayApi.doAction(actionId, root, "wn_acct");
		return resultMap.toString();
		
//		return "";
	}
}
