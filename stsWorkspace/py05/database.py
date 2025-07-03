# import contextlib

import os
from dotenv import load_dotenv
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

import models

# load_dotenv()
# user = os.getenv("DB_USER")     # "root"
# passwd = os.getenv("DB_PASSWD") # "1234"
# host = os.getenv("DB_HOST")     # "127.0.0.1"
# port = os.getenv("DB_PORT")     # "3306"
# db = os.getenv("DB_NAME")       # "mydb"


# SQLALCHEMY_DATABASE_URL = "sqlite:///./myapi.db"
# SQLALCHEMY_DATABASE_URL = f'mysql+pymysql://{user}:{passwd}@{host}:{port}/{db}?charset=utf8'
SQLALCHEMY_DATABASE_URL = "mysql+pymysql://scott:tiger@localhost:3306/xe"
engine = create_engine(
    SQLALCHEMY_DATABASE_URL
)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()

# @contextlib.contextmanager
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


# models.Base.metadata.create_all(bind=engine)