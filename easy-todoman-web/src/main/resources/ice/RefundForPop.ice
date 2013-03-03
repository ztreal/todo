module Jd{
	module Refund{
		module RefundPopService{
			/*POP申请异常*/
			exception ApplyIsNotAllow{
				string Message;
			};
			
			/* POP申请退款时所需的参数类 */
			class PopRequest{
				int OrderId;				//订单号
				int RequestType;			//申请类型 返余(1) 银行卡返现(2) 原路返回(3)
				int TypeOfRfid;				//单据类型 虚拟团购：28；实物团购：29；游戏点卡：34；机票：35
				int SourceType;				//申请来源：客服(0) 客户(2) 系统(3)
				bool IsDeleteOrder;			//是否删单
				double RefundMoney;			//退款金额
				string RequestPerson;		//申请人(填写下单用户的账号)
				string RequestPersonName;	//申请人姓名
				string RequestReason;		//申请理由
				string AcceptPerson;		//受理人
				string UserId;				//用户ID
				string TransactionNumber;	//交易号 团购：tg_流水号,机票：jp_流水号,虚拟点卡：card_流水号
				string RequestInfoUrl;		//查看退款明细的链接(带域名的完整的Url)
				string PhoneNo;				//手机号
				string BankName;			//银行名称
				string BankProvince;		//银行所在省份
				string BankCity;			//银行所在城市
				string SubBankName;			//分行名称
				string BankUserName;		//开户名
				string BankCardNo;			//银行卡号
				string TranscationToken;	//业务Token用于验证权限
				int    IntAttr1;			//Int属性1
				int    IntAttr2;			//Int属性2
				int	   IntAttr3;			//Int属于3
				string StringAttr1;			//String属性1
				string StringAttr2;			//String属性2
				string StringAttr3;			//String属性3
			};
			
			/*POP调用退款接口后返回的结果类*/
			class Result{
				int RequestId;				//退款申请单号(退款成功后传递此参数)
				bool IsSuccess;				//是否成功
				string FailCode;			//失败码
				string FailMessage;			//失败信息
				string StrAttr1;			//String预留属性
			};
			/*POP退款申请接口*/
			interface PopRefundService{
			/*POP退款申请时调用的接口*/
				Result PopRefundApply(PopRequest reqParam);
				
				string TestMessage(string message);
			};
		};
	};
};