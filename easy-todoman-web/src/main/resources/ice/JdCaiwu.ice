module Jd{
	module Caiwu{
		 /** 余额/积分实体 **/
		struct UB{
			string pin;
			double Amount;
			string Rfid;
			int RfidType;
			string Operator;
			string Uuid;
			string notes;	
			string IP;
			long CreateDate;
		};
		struct CwPager{
			long StartTimeTicks;
			long EndTimeTikes;
			int StartPoint;
			int PageSize;
			bool IsGetTotalNum;
		};

		["java:type:java.util.ArrayList"]
		sequence<UB> UBList;

		exception CaiwuException{
			string message;
		};

		exception AuthenticationException extends CaiwuException{			
		};

		interface BalanceService{
			/** 增加余额 **/
			bool AddUB(UB u) throws CaiwuException,AuthenticationException;
			/** 订单多支付金额返还余额（完成时） **/
			bool AddUBforOrder(UB u) throws CaiwuException,AuthenticationException;
			/** 减少余额 **/
			bool DeductUB(UB u,bool isfored) throws CaiwuException,AuthenticationException;
			/** 锁定余额 **/
			bool LockUB(UB u) throws CaiwuException,AuthenticationException;
			/** 解锁余额 **/
			bool UnlockUB(UB u) throws CaiwuException,AuthenticationException;
			/** 提交锁定 **/
			bool CommitLockUB(UB u) throws CaiwuException,AuthenticationException;
			/** 获取余额 **/
			double GetUB(string pin) throws CaiwuException,AuthenticationException;
			/** 获取汇总余额 **/
			double GetUBwithCalc(string pin) throws CaiwuException,AuthenticationException;
			/** 获取明细 **/
			UBList GetUBList(string pin,long startTime,long endTime) throws CaiwuException,AuthenticationException;
			/** 获取明细带分页 **/
			UBList GetUBListwithPager(string pin,CwPager pager,out int totalnum) throws CaiwuException,AuthenticationException;
		};

		interface ScoreService{
			/** 添加积分 **/
			bool AddUS(UB u) throws CaiwuException,AuthenticationException;
			/** 订单赠送积分（完成时） **/
			bool AddUSforOrder(UB u,int wid) throws CaiwuException,AuthenticationException;
			/** 扣除积分 **/
			bool DeductUS(UB u,bool isfored) throws CaiwuException,AuthenticationException;
			/** 获取积分 **/
			int GetUS(string pin) throws CaiwuException,AuthenticationException;
			/** 获取积分 **/
			int GetUSwithCalc(string pin) throws CaiwuException,AuthenticationException;
			/** 获取明细 **/
			UBList GetUSList(string pin,long startTime,long endTime) throws CaiwuException,AuthenticationException;
			/** 获取明细带分页 **/
			UBList GetUSListwithPager(string pin,CwPager pager,out int totalnum) throws CaiwuException,AuthenticationException;
		};
		struct Jdcaiwu{
			int cdanhao;
			int kdanhao;
			bool jiedai;
			int orderid;
			string fangshi;
			string fenlei;
			string city;
			string jigou;
			string jingban;
			string luru;
			string laiyuan;
			string daxie;
			double zjine;
			double yeji;
			int yn;
			int qianzi;
			long createtime;
			long lasttime;
			string remark;
			double yun;
			double youhui;
			double qita;
			string bumen;
			string yinhang;
			int ischeck;
			string jibancode;
			string lurucode;
			string laiyuancode;
			int iyinhang;
			int ifangshi;
			int ijiedai;
			int ifenlei;
			int ijigou;
			int ibumen;			
		};

		["java:type:java.util.ArrayList"]
		sequence<Jdcaiwu> Cdans;

		sequence<int> cdanarr;

		interface CdanService{
			/** 添加财务单 **/
			int AddCdanhao(Jdcaiwu cdan) throws CaiwuException,AuthenticationException;
			/** 添加财务单 **/
			cdanarr AddCdanhaoTrans(Cdans cdanhaos) throws CaiwuException,AuthenticationException;
			/** 获取财务单 **/
			Jdcaiwu GetCdanhao(int cdanhao) throws CaiwuException,AuthenticationException;
			/** 根据订单获取财务单 **/
			Jdcaiwu GetCdanhaoByOrderid(int orderid) throws CaiwuException,AuthenticationException;
			/** 修改财务单（特定字段） **/
			bool UpdateCdan(int cdanhao,int kdanhao) throws CaiwuException,AuthenticationException;
		};
	};
};