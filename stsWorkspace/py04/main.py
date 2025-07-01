from fastapi import FastAPI
from typing import Union
from pydantic import BaseModel
from mysql import connector

app = FastAPI()
# mydb = connector.connect(
#   host="localhost",
#   user="scott",
#   password="tiger",
#   database="xe",
# )

# mycursor = mydb.cursor()

# mycursor.execute("CREATE DATABASE xe2")
# mycursor.execute("SHOW DATABASES")
# for x in mycursor:
#   print(x)
# mycursor.execute("CREATE TABLE customers (name VARCHAR(255), address VARCHAR(255))")
# mycursor = mydb.cursor()
# mycursor.execute("drop TABLE customers")


# mydb.close()

@app.get("/dept")
def deptList():
    print('list')
    arrlist=[]
    mydb = connector.connect(
            host="localhost",
            user="scott",
            password="tiger",
            database="xe",
            )

    mycursor = mydb.cursor()
    try:
        mycursor.execute('select * from dept')
        myresult = mycursor.fetchall()
        print(myresult)
        for x in myresult:
            print(x)
            arrlist.append(x)
    except:
        mydb.rollback()
    else:
        mydb.commit()
    finally:
        mycursor.close()
        mydb.close()
    return arrlist

@app.get("/")
async def root():
    return {"message": "Hello World"}

@app.get('/intro')
def intro():
    return {'title':'intro page'}

@app.get('/ex01')
def ex01(msg=''):
    return {'msg':msg}

class DeptVo(BaseModel):
    deptno: int
    dname: str
    loc: str

@app.post('/ex02')
def ex02(dept: DeptVo):
    return dept

@app.get('/list')
def ex03():
    return [
        {'deptno':1111,'dname':'user1','loc':'test'},
        {'deptno':2222,'dname':'user2','loc':'test'},
        ]

@app.get("/{item_id}")
async def read_item(item_id: str, q: Union[str, None] = None):
    if q:
        return {"item_id": item_id, "q": q}
    return {"item_id": item_id}

@app.post('/dept')
def deptAdd(dept: DeptVo):
    sql="insert into dept (dname,loc) values ('{0}','{1}')".format(dept.dname,dept.loc)
    print(sql)
    mydb = connector.connect(
            host="localhost",
            user="scott",
            password="tiger",
            database="xe",
            )

    mycursor = mydb.cursor()
    try:
        # mycursor.execute(sql)
        # mycursor.execute(
        #     "insert into dept (dname,loc) values (%s,%s)",[dept.dname,dept.loc])
        mycursor.execute(
            f"insert into dept (dname,loc) values ('{dept.dname}','{dept.loc}')")
    except:
        mydb.rollback()
    else:
        mydb.commit()
    finally:
        mycursor.close()
        mydb.close()
        return dept

@app.get('/test')
def test():
    return 'test'