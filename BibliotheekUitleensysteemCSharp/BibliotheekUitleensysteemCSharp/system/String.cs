using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class String : IComparable
{
    public int length = 0;
    private readonly string city;

    public String(string city)
    {
        if (city == null)
            throw new ArgumentNullException("city");

        this.city = city;
    }

    public override bool Equals(object obj)
    {
        String other = obj as String;
        return (other != null) && this.city.Equals(other.city);
    }

    public override int GetHashCode()
    {
        return this.city.GetHashCode();
    }

    public override string ToString()
    {
        return this.city;
    }

    public static implicit operator string(String city)
    {
        return city.city;
    }

    public static implicit operator String(string city)
    {
        return new String(city);
    }

    public bool equals(object obj)
    {
        String other = obj as String;
        return (other != null) && this.city.Equals(other.city);
    }

    public String[] split(String regex, int limit)
    {
        return new String[2] {new String("test"), new String("test")};
    }
    public String replace(String oldChar, String newChar)
    {
        return "";   
    }

    public String replaceFirst(String regex, String replacement)
    {
        return "";   
    }

    public String substring(int beginIndex, int endIndex)
    {
        return "";   
    }

    public String substring(int beginIndex)
    {
        return "";   
    }

    public Boolean isEmpty()
    {
        return true;
    }

    public String toUpperCase()
    {
        return "";   
    }

    public int CompareTo(object obj)
    {
        return 0;
    }
}