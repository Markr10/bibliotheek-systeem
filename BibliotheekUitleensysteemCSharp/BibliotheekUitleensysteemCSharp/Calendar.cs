using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace java.util.Calendar
{
    public class Calendar
    {
        public static readonly int DAY_OF_MONTH = 0;
        public static readonly int MONTH = 0;
        public static readonly int YEAR = 0;

        public static Calendar getInstance()
        {
            return new Calendar();
        }
        public int get(int field)
        {
            return 0;
        }

        public Date getTime()
        {
            return new java.util.Date();
        }

        public void setTime(Date date)
        {
        }

        public void add(int field, int amount)
        {
        }

        public long getTimeInMillis()
        {
            return 0;
        }
    }
}
