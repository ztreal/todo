module Jd{
	module Refund{
		module RefundPopService{
			/*POP�����쳣*/
			exception ApplyIsNotAllow{
				string Message;
			};
			
			/* POP�����˿�ʱ����Ĳ����� */
			class PopRequest{
				int OrderId;				//������
				int RequestType;			//�������� ����(1) ���п�����(2) ԭ·����(3)
				int TypeOfRfid;				//�������� �����Ź���28��ʵ���Ź���29����Ϸ�㿨��34����Ʊ��35
				int SourceType;				//������Դ���ͷ�(0) �ͻ�(2) ϵͳ(3)
				bool IsDeleteOrder;			//�Ƿ�ɾ��
				double RefundMoney;			//�˿���
				string RequestPerson;		//������(��д�µ��û����˺�)
				string RequestPersonName;	//����������
				string RequestReason;		//��������
				string AcceptPerson;		//������
				string UserId;				//�û�ID
				string TransactionNumber;	//���׺� �Ź���tg_��ˮ��,��Ʊ��jp_��ˮ��,����㿨��card_��ˮ��
				string RequestInfoUrl;		//�鿴�˿���ϸ������(��������������Url)
				string PhoneNo;				//�ֻ���
				string BankName;			//��������
				string BankProvince;		//��������ʡ��
				string BankCity;			//�������ڳ���
				string SubBankName;			//��������
				string BankUserName;		//������
				string BankCardNo;			//���п���
				string TranscationToken;	//ҵ��Token������֤Ȩ��
				int    IntAttr1;			//Int����1
				int    IntAttr2;			//Int����2
				int	   IntAttr3;			//Int����3
				string StringAttr1;			//String����1
				string StringAttr2;			//String����2
				string StringAttr3;			//String����3
			};
			
			/*POP�����˿�ӿں󷵻صĽ����*/
			class Result{
				int RequestId;				//�˿����뵥��(�˿�ɹ��󴫵ݴ˲���)
				bool IsSuccess;				//�Ƿ�ɹ�
				string FailCode;			//ʧ����
				string FailMessage;			//ʧ����Ϣ
				string StrAttr1;			//StringԤ������
			};
			/*POP�˿�����ӿ�*/
			interface PopRefundService{
			/*POP�˿�����ʱ���õĽӿ�*/
				Result PopRefundApply(PopRequest reqParam);
				
				string TestMessage(string message);
			};
		};
	};
};