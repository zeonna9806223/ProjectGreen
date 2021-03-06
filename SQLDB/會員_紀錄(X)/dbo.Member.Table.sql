USE [YI]
GO
/****** Object:  Table [dbo].[Member]    Script Date: 2020/4/13 下午 12:12:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Member](
	[MemberID] [nchar](10) NOT NULL,
	[MemberAccount] [varchar](18) NULL,
	[MemberPWD] [varchar](36) NULL,
	[IDCard] [varchar](10) NULL,
	[PassPort] [varchar](50) NULL,
	[MemberName] [nchar](30) NULL,
	[MemberNickName] [nvarchar](10) NULL,
	[Gender] [tinyint] NULL,
	[MemberBirthday] [date] NULL,
	[PhoneAreaCode] [varchar](4) NULL,
	[MemberPhone] [varchar](12) NULL,
	[CellPhoneAreaCode] [varchar](8) NOT NULL,
	[MemberCellPhone] [varchar](11) NULL,
	[MemberEmail] [varchar](50) NULL,
	[MemberAddress] [nvarchar](100) NULL,
	[MemberURL] [nchar](100) NULL,
	[MemberJoinDate] [datetime] NULL,
	[MemberAvailable] [tinyint] NULL,
	[MemberPermission] [int] NULL,
	[VIP] [tinyint] NULL,
	[RegisterState] [int] NULL,
	[MemberIntroduce] [text] NULL,
 CONSTRAINT [PK_Member1] PRIMARY KEY CLUSTERED 
(
	[MemberID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
