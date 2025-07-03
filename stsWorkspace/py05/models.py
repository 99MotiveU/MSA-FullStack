from datetime import datetime

from pydantic import BaseModel, Field
from sqlalchemy import Column,INT,VARCHAR, Integer, String, Text,TIMESTAMP, DateTime, ForeignKey
from sqlalchemy.orm import relationship
from database import Base


class Question(Base):
    __tablename__ = "question"

    id = Column(INT, primary_key=True)
    subject = Column(VARCHAR(50), nullable=False)
    content = Column(Text, nullable=False)
    create_date = Column(TIMESTAMP, nullable=False)


# class Answer(Base):
#     __tablename__ = "answer"

#     id = Column(Integer, primary_key=True)
#     content = Column(Text, nullable=False)
#     create_date = Column(DateTime, nullable=False)
#     question_id = Column(Integer, ForeignKey("question.id"))
#     question = relationship("Question", backref="answers")