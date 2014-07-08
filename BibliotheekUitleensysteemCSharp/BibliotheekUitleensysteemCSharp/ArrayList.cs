using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace java.util
{
    public class ArrayList<E> : System.Collections.ArrayList
    {
        public int size()
        {
            return 0;
        }

        public void add(E e)
        {
        }

        public E get(int index)
        {
            return default(E);
        }

        public String toString()
        {
            return new String("test");
        }

        internal Reservering get(lang.Integer reserveringID)
        {
            return null;
        }
    }
}
