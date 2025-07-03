# java - bean,dto,vo
import datetime
from typing import Union

from pydantic import BaseModel


class Question(BaseModel):
    id: int
    subject: str
    content: Union[str, None] = None
    create_date: datetime.datetime