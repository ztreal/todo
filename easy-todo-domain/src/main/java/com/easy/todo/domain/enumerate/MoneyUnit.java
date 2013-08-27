package com.easy.todo.domain.enumerate;

/**
 * 中国货币单位.
 * User: zhangtan
 * Date: 13-8-27
 * Time: 上午10:36
 */
public enum  MoneyUnit {

    YUAN {
           public long toYuan(long d)   { return d; }
           public long toJiao(long d)  { return d*(C1*C0); }
           public long toFen(long d)  { return d*(C2*C0); }
           public long convert(long d, MoneyUnit u) { return u.toYuan(d); }
       },
       JIAO {
           public long toYuan(long d)   { return x(d, C1*C0, MAX); }
           public long toJiao(long d)  { return d; }
           public long toFen(long d)  { return d*(C2*C1); }
           public long convert(long d, MoneyUnit u) { return u.toJiao(d); }
       },
       FEN {
           public long toYuan(long d)   { return x(d, C2*C0, MAX); }
           public long toJiao(long d)  { return x(d, C2*C1, MAX); }
           public long toFen(long d)  { return d; }
           public long convert(long d, MoneyUnit u) { return u.toFen(d); }
       };

       // Handy constants for conversion methods
       static final long C0 = 10L;
       static final long C1 = C0 * 10L;
       static final long C2 = C1 * 10L;

       static final long MAX = Long.MAX_VALUE;

       /**
        * Scale d by m, checking for overflow.
        * This has a short name to make above code more readable.
        */
       static long x(long d, long m, long over) {
           if (d >  over) return Long.MAX_VALUE;
           if (d < -over) return Long.MIN_VALUE;
           return d * m;
       }



       /**
        * 转换相应单位货币为对应的值
        * <p>For example, to convert 10 Yuan to Fen, use:
        * <tt>MoneyUnit.FEN.convert(10L, MoneyUnit.YUAN)</tt>
        *
        * @param sourceDuration 转换来源值
        * @param sourceUnit 换换来源单位
        * @return 转换结果,
        * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
        * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
        */
       public long convert(long sourceDuration, MoneyUnit sourceUnit) {
           throw new AbstractMethodError();
       }

 
       public long toYuan(long duration) {
           throw new AbstractMethodError();
       }

 
       public long toJiao(long duration) {
           throw new AbstractMethodError();
       }

 
       public long toFen(long duration) {
           throw new AbstractMethodError();
       }

       




}

