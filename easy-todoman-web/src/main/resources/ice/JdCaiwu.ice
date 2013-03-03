module Jd{
	module Caiwu{
		 /** ���/����ʵ�� **/
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
			/** ������� **/
			bool AddUB(UB u) throws CaiwuException,AuthenticationException;
			/** ������֧�����������ʱ�� **/
			bool AddUBforOrder(UB u) throws CaiwuException,AuthenticationException;
			/** ������� **/
			bool DeductUB(UB u,bool isfored) throws CaiwuException,AuthenticationException;
			/** ������� **/
			bool LockUB(UB u) throws CaiwuException,AuthenticationException;
			/** ������� **/
			bool UnlockUB(UB u) throws CaiwuException,AuthenticationException;
			/** �ύ���� **/
			bool CommitLockUB(UB u) throws CaiwuException,AuthenticationException;
			/** ��ȡ��� **/
			double GetUB(string pin) throws CaiwuException,AuthenticationException;
			/** ��ȡ������� **/
			double GetUBwithCalc(string pin) throws CaiwuException,AuthenticationException;
			/** ��ȡ��ϸ **/
			UBList GetUBList(string pin,long startTime,long endTime) throws CaiwuException,AuthenticationException;
			/** ��ȡ��ϸ����ҳ **/
			UBList GetUBListwithPager(string pin,CwPager pager,out int totalnum) throws CaiwuException,AuthenticationException;
		};

		interface ScoreService{
			/** ��ӻ��� **/
			bool AddUS(UB u) throws CaiwuException,AuthenticationException;
			/** �������ͻ��֣����ʱ�� **/
			bool AddUSforOrder(UB u,int wid) throws CaiwuException,AuthenticationException;
			/** �۳����� **/
			bool DeductUS(UB u,bool isfored) throws CaiwuException,AuthenticationException;
			/** ��ȡ���� **/
			int GetUS(string pin) throws CaiwuException,AuthenticationException;
			/** ��ȡ���� **/
			int GetUSwithCalc(string pin) throws CaiwuException,AuthenticationException;
			/** ��ȡ��ϸ **/
			UBList GetUSList(string pin,long startTime,long endTime) throws CaiwuException,AuthenticationException;
			/** ��ȡ��ϸ����ҳ **/
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
			/** ��Ӳ��� **/
			int AddCdanhao(Jdcaiwu cdan) throws CaiwuException,AuthenticationException;
			/** ��Ӳ��� **/
			cdanarr AddCdanhaoTrans(Cdans cdanhaos) throws CaiwuException,AuthenticationException;
			/** ��ȡ���� **/
			Jdcaiwu GetCdanhao(int cdanhao) throws CaiwuException,AuthenticationException;
			/** ���ݶ�����ȡ���� **/
			Jdcaiwu GetCdanhaoByOrderid(int orderid) throws CaiwuException,AuthenticationException;
			/** �޸Ĳ��񵥣��ض��ֶΣ� **/
			bool UpdateCdan(int cdanhao,int kdanhao) throws CaiwuException,AuthenticationException;
		};
	};
};