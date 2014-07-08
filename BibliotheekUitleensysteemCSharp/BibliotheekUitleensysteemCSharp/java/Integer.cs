using System;
namespace java.lang
{
    public struct Integer
    {
        private const int mask = 0x08FF;
        private int val;
        private bool isDef;


        private Integer(int value)
        {
            val = value & mask;
            isDef = true;
        }
        public static Integer Make(int value)
        { return new Integer(value); }

        public int Value { get { return val; } }
        public bool HasValue { get { return isDef; } }

        public static Integer Null = new Integer();

        public static explicit operator int(Integer twentyBit)
        {
            //  if (!HasValue) throw new ArgumentNullValueException();
            return twentyBit.val;
        }

        public static implicit operator Integer(int integerValue)
        {
            return Make(integerValue);
        }

        public static int parseInt(String s)
        {
            return 0;
        }
    }
}